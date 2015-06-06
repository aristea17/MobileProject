package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ShoppingCartServlet extends HttpServlet{
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	private static Date date;
	private static String uniqueOrderDate;
	private final Path PATH_HOME = Paths.get(System.getProperty("user.home"));
	private final String PATH_TO_FOLDER = "\\Documents\\GitHub\\MobileProject\\MobileProject\\Orders\\";

	/* Do get receives information from ajax */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		/* Depending on hard-coded ID in ajax function, we know the action we are performing on the Shopping Cart */
		int id = Integer.parseInt(request.getParameter("ID"));
		
		/* 1: Add BuyProduct to cart
		 * 2: Send email to suppliers based on ShoppingCart content
		 * 3: Removes a BuyProduct form cart
		 * 4: Updates a BuyProduct quantity in the cart
		 * default : Print to console a string - Should never appear because of ID hard-coded and not generated */
		switch(id){
		case 1 : add(request);
								/* // Set response content type
								String toResponse =
								response.setContentType("text/plain");
								response.setCharacterEncoding("UTF-8");
								response.getWriter().write(toResponse);
								*/
			break;
		case 2 : if(!ShoppingCart.isEmpty()) send(request);
								/* // Set response content type
								String toResponse =
								response.setContentType("text/plain");
								response.setCharacterEncoding("UTF-8");
								response.getWriter().write(toResponse);
								*/
			break;
		case 3 : remove(request);
			break;
		case 4 : reduce(request);
			break;
		default : System.out.println("Wrong ID: Where do you come from, dude...?");
		}
	}
	
	/* PRIVATE AddToCart */
	private void add(HttpServletRequest request){
		/* Gets parameters from ajax */
		String p_name = request.getParameter("pName");
		String s_name = request.getParameter("sName");
		String s_email = request.getParameter("sEmail");
		double price = Double.parseDouble(request.getParameter("pPrice"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		/* Creates BuyProducts and adds it to Cart */
		BuyProduct p = new BuyProduct(p_name, quantity, price, s_name, s_email);
		ShoppingCart.addToCart(p);
		
		//String toReturn = p_name + " added to Shopping Cart! test: " + test;
		//return toReturn;
	}
	
	/* PRIVATE Send Email */
	private void send(HttpServletRequest request){
		//String toResponse = "";
		List<Order> orderList = ShoppingCart.getOrderList();
		List<String[]> sendList = new ArrayList<String[]>();
		
								/* Print in console to know status of send procedure */
								int count = 1;		
								System.out.println("START GENERATING PDFs");
		
		/* For each order in ShoppingCart (already divided by supplier) we generate an order-PDF */
		for(Order current : orderList){
			String[] info = new String[3];
			
								System.out.println("PDF " + count);
			
			/* Generate unique time stamp for each mail */
			generateOrderDate();
			
			/* We generate order-PDF to send */
			String file = "Order for " + current.getSupplier() + " " + uniqueOrderDate + ".pdf";
			generatePdf(current, file);
			
			/* Add to list info to send email in a second moment */
			info[0] = current.getEMail();
			info[1] = uniqueOrderDate;
			info[2] = file;
			sendList.add(info);
			
								count++;
		}
	
								System.out.println("END PDF SESSION");
		
		/* Clears shopping cart */
		ShoppingCart.clear();
		
								System.out.println("CART CLEARED");								
								System.out.println("START SENDING EMAIL");
		
								int i = 0;
		/* Send email */
		for(String[] currentInfo : sendList){
								System.out.println("EMAIL " + (i+1));

			sendEmail(currentInfo);
								/*String fromMail = */
								//toResponse += "Order: " + current.getSupplier() + "\n" + fromMail;
			
								System.out.println("EMAIL " + (i+1) + " SENT");
								i++;
		}
								System.out.println("END SEND SESSION");
								//return toResponse;
	}
	
	/* PRIVATE Remove BuyProduct from cart */
	private void remove(HttpServletRequest request){
		/* Gets parameters from ajax */
		String p_name = request.getParameter("pName");
		String s_name = request.getParameter("sName");

		/* Removes BuyProduct based on name and supplier */
		ShoppingCart.remove(s_name, p_name);		
	}
	
	/* PRIVATE Update BuyProduct's quantity */
	private void reduce(HttpServletRequest request){
		/* Gets parameters from ajax */
		String p_name = request.getParameter("pName");
		String s_name = request.getParameter("sName");
		int quantity = Integer.parseInt(request.getParameter("iQuantity"));
		
		/* Reduces BuyProduct's quantity based on name and supplier */
		ShoppingCart.reduce(s_name, p_name, quantity);		
	}
	
	/* PRIVATE Generate unique time stamp */
	private static void generateOrderDate(){
		date = new Date();
		uniqueOrderDate = dateFormat.format(date);
	}
	
	/* PRIVATE Generate PDF-file for an Order */
	private void generatePdf(Order order, String fileName){
		
		try {
			/* Setup to create pdf */
			File file = new File(PATH_HOME + PATH_TO_FOLDER + fileName);
			FileOutputStream fileout = new FileOutputStream(file);
			Document document = new Document();
			PdfWriter.getInstance(document, fileout);
			
			/* Open document and start writing to it adding the structured order in form of paragraphs */
			document.open();
			
			Paragraph p1 = new Paragraph();
			p1.add("Hello!\nThis is our order in date " + uniqueOrderDate + "\n\n");
			
			Paragraph p2 = new Paragraph();
			p2.add(order.stringMyOrder());
			
			Paragraph p3 = new Paragraph();
			p3.add("\nThank you!");
			
			document.add(p1);
			document.add(p2);
			document.add(p3);
			
			/* Close created document */
			document.close();			
			fileout.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* PRIVATE Send Email */
	private void sendEmail(String[] info){
								//String toReturn = "";
		
		/* Sender information */
		String from = "imsunibz@gmail.com";
		final String PSW = "ims15unibz";
		
		/* Get System properties */
		Properties props = new Properties();
		
		/* Setup mail server */
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
			
		/* Get default Session object */
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, PSW);
					}
				  });
		
		try{
			/* Create a default MimeMessage */
			MimeMessage message = new MimeMessage(session);
			
			/* Set FROM and TO - Subject and actual message */
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(info[0]));
			message.setSubject("Supply order for IMS-2k15 - " + info[1]);
			
			/* We create a Multipart object to structure our email */
			Multipart multiP = new MimeMultipart();
			BodyPart bodyP = new MimeBodyPart();
			bodyP.setText("Order from IMS Hotel in attachment\n\n Thanks!");
						
			multiP.addBodyPart(bodyP);
			
			/* Add attachment */
			bodyP = new MimeBodyPart();
			String filePath = PATH_HOME + PATH_TO_FOLDER + info[2];
			DataSource source = new FileDataSource(filePath);
			bodyP.setDataHandler(new DataHandler(source));
			bodyP.setFileName(info[2]);
			multiP.addBodyPart(bodyP);
			
			/* Set content of our email with the Multipart created */
			message.setContent(multiP);
			
			/* Send Message */
			Transport.send(message);
			
								//toReturn = "Send Email: \nSent message successfully\n\n";
		}catch (MessagingException mex) {
	         mex.printStackTrace();
	         					//toReturn = "Send Email: \nFAILED!\n\n";
	      }
								//return toReturn;
	}
	
}
