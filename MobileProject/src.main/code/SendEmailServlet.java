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

public class SendEmailServlet extends HttpServlet{
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	private static Date date;
	private static String uniqueOrderDate;
	private Path path = Paths.get(System.getProperty("user.home"));

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String toResponse = "";
		List<Order> orderList = ShoppingCart.getOrderList();
		int count = 1; //
		
		System.out.println("START SENDING EMAIL - " + count);
		
		for(Order current : orderList){
			generateOrderDate();
			String file = "Order for " + current.getSupplier() + " " + uniqueOrderDate + ".pdf";
			generatePdf(current, file);
			toResponse += "Order: " + current.getSupplier() +
					"\n" + sendEmail(current.getEMail(), file);
			System.out.println("EMAIL SEND - " + count);
			count++;
		}
	
		System.out.println("END SEND SESSION - " + count);
		
		ShoppingCart.clear();
		
		System.out.println("CART CLEARED - ");
		
		// Set response content type
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(toResponse);
	}
	
	private static void generateOrderDate(){
		date = new Date();
		uniqueOrderDate = dateFormat.format(date);
		System.out.println(uniqueOrderDate);
	}
	
	private void generatePdf(Order order, String fileName){
		try {	
			
			File file = new File(path + "\\Documents\\GitHub\\MobileProject\\MobileProject\\Orders\\" + fileName);
			FileOutputStream fileout = new FileOutputStream(file);
			Document document = new Document();
			PdfWriter.getInstance(document, fileout);
			
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
	
	private String sendEmail(String to, String fileName){
		String toReturn = "empty";
		String from = "imsunibz@gmail.com";
		final String password = "ims15unibz";
		
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
						return new PasswordAuthentication(from, password);
					}
				  });
		
		try{
			// Create a default MimeMessage
			MimeMessage message = new MimeMessage(session);
			
			// Set FROM and TO - Subject and actual message
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Supply order for IMS-2k15 - " + uniqueOrderDate);
			
			BodyPart bp = new MimeBodyPart();
			bp.setText("Order from IMS Hotel in attachment\n\n Thanks!");
			
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(bp);
			
			bp = new MimeBodyPart();
			String filePath = path + "\\Documents\\GitHub\\MobileProject\\MobileProject\\Orders\\" + fileName;
			DataSource source = new FileDataSource(filePath);
			bp.setDataHandler(new DataHandler(source));
			bp.setFileName(fileName);
			mp.addBodyPart(bp);
			message.setContent(mp);
			
			// Send Message
			Transport.send(message);
			
			toReturn = "Send Email: \nSent message successfully\n\n";
		}catch (MessagingException mex) {
	         mex.printStackTrace();
	         toReturn = "Send Email: \nFAILED!\n\n";
	      }
		return toReturn;
	}
}
