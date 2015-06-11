package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserManager;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		/* Get request parameters for username & password */
		String username =  request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
		
		/* Authentication check */
		boolean valid = UserManager.authenticate(username, password);
		
		HttpSession session;
		
		/* Authentication - if failed redirects to an error page, else access the Home page */
		if(valid){
			session = request.getSession(true);
			session.setAttribute("user", username);
			response.sendRedirect("homePage.jsp"); 
		}else{
			request.setAttribute("error", "Invalid user");
			response.sendRedirect("invalidLogin.jsp");
		}
	}
}