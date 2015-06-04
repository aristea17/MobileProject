package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

	// Do get receives information from ajax
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		// Depending on hard-coded ID in ajax function, we know the action we are performing on the Shopping Cart
		int id = Integer.parseInt(request.getParameter("ID"));
		
		switch(id){
		// Add BuyProduct to cart
		case 1 : add(request);
			/* // Set response content type
			String toResponse =
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(toResponse);
			*/
			break;
		// Send email to suppliers based on ShoppingCart content
		case 2 : send(request);
			/* // Set response content type
			String toResponse =
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(toResponse);
			*/
			break;
		// Removes a BuyProduct form cart
		case 3 : remove(request);
			break;
		// Updates a BuyProduct quantity in the cart
		case 4 : update(request);
			break;
		default : System.out.println("Wrong ID: Where do you come from, dude...?");
		}
	}
	
	// AddToCart
	private void add(HttpServletRequest request){
		// Gets parameters from ajax
		String p_name = request.getParameter("pName");
		String s_name = request.getParameter("sName");
		String s_email = request.getParameter("sEmail");
		double price = Double.parseDouble(request.getParameter("pPrice"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		// Creates BuyProducts and adds it to Cart
		BuyProduct p = new BuyProduct(p_name, quantity, price, s_name, s_email);
		ShoppingCart.addToCart(p);
		
		//String toReturn = p_name + " added to Shopping Cart! test: " + test;
		//return toReturn;
	}
	
	// Send Email
	private void send(HttpServletRequest request){
		//String toResponse = "";
		List<Order> orderList = ShoppingCart.getOrderList();
		
		int count = 1;		
		System.out.println("START SENDING EMAILS");
		
		// For each order in ShoppingCart (already divided by supplier) we send an email
		for(Order current : orderList){
			
			System.out.println("EMAIL " + count);
			
			// Generate unique time stamp for each mail
			generateOrderDate();
			
			// We generate pdf-order to send
			String file = "Order for " + current.getSupplier() + " " + uniqueOrderDate + ".pdf";
			generatePdf(current, file);
			
			// Send email
			sendEmail(current.getEMail(), file);
			/*String fromMail = */
			//toResponse += "Order: " + current.getSupplier() + "\n" + fromMail;
			
			System.out.println("EMAIL " + count + " SENT");
			count++;
		}
	
		System.out.println("END SEND SESSION");
		
		ShoppingCart.clear();
		
		System.out.println("CART CLEARED");
		
		//return toResponse;
	}
	
	// Remove BuyProduct from cart
	private void remove(HttpServletRequest request){
		// Gets parameters from ajax
		String p_name = request.getParameter("pName");
		String s_name = request.getParameter("sName");

		// Removes BuyProduct based on name and supplier
		ShoppingCart.remove(s_name, p_name);
		
	}
	
	// Update BuyProduct's quantity
	private void update(HttpServletRequest request){
		// Gets parameters from ajax
		String p_name = request.getParameter("pName");
		String s_name = request.getParameter("sName");
		int quantity = Integer.parseInt(request.getParameter("iQuantity"));
		
		// Update BuyProduct based on name and supplier
		ShoppingCart.update(s_name, p_name, quantity);
		
	}
	
	// Generate unique time stamp
	private static void generateOrderDate(){
		date = new Date();
		uniqueOrderDate = dateFormat.format(date);
		//System.out.println(uniqueOrderDate);
	}
	
	private void generatePdf(Order order, String fileName){
		
		try {
			// Setup to create pdf
			File file = new File(PATH_HOME + PATH_TO_FOLDER + fileName);
			FileOutputStream fileout = new FileOutputStream(file);
			Document document = new Document();
			PdfWriter.getInstance(document, fileout);
			
			// Open document and start writing to it adding the structured order in form of paragraphs
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
			
			// Close created document
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
	
	private void sendEmail(String to, String fileName){
		//String toReturn = "";
		
		// Sender information
		String from = "imsunibz@gmail.com";
		final String PSW = "ims15unibz";
		
		// Get System properties
		Properties props = new Properties();
		
		// Setup mail server
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
			
		// Get default Session object;
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, PSW);
					}
				  });
		
		try{
			// Create a default MimeMessage
			MimeMessage message = new MimeMessage(session);
			
			// Set FROM and TO - Subject and actual message
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Supply order for IMS-2k15 - " + uniqueOrderDate);
			
			// We create a Multipart object to structure our email
			Multipart mp = new MimeMultipart();
			BodyPart bp = new MimeBodyPart();
			bp.setText("Order from IMS Hotel in attachment\n\n Thanks!");
						
			mp.addBodyPart(bp);
			
			// Add attachment
			bp = new MimeBodyPart();
			String filePath = PATH_HOME + PATH_TO_FOLDER + fileName;
			DataSource source = new FileDataSource(filePath);
			bp.setDataHandler(new DataHandler(source));
			bp.setFileName(fileName);
			mp.addBodyPart(bp);
			
			// Set content of our email with the Multipart created
			message.setContent(mp);
			
			// Send Message
			Transport.send(message);
			
			//toReturn = "Send Email: \nSent message successfully\n\n";
		}catch (MessagingException mex) {
	         mex.printStackTrace();
	         //toReturn = "Send Email: \nFAILED!\n\n";
	      }
		//return toReturn;
	}
	
}
