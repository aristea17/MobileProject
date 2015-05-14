package code;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendEmailServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String to = "ibershimiaristea@yahoo.com";
		String from = "imsunibz@gmail.com";
		//String host = "localhost";
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
		
		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try{
			// Create a default MimeMessage pject
			MimeMessage message = new MimeMessage(session);
			
			// Set FROM and TO - Subject and actual message
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Subj line");
			message.setText("The most awsome test message ever");
			
			// Send Message
			Transport.send(message);
			String title = "Send Email";
	         String res = "Sent message successfully....";
	         String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
	         out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor=\"#f0f0f0\">\n" +
	         "<h1 align=\"center\">" + title + "</h1>\n" +
	         "<p align=\"center\">" + res + "</p>\n" +
	         "</body></html>");
		}catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	
	}
	
}
