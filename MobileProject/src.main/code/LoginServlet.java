package code;
import hibernate.ProductsManager;
import hibernate.SuppliersManager;
import hibernate.UserManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String username =  request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
		
		boolean valid = UserManager.authenticate(username, password);
		
		HttpSession session;
		if(valid){
			session = request.getSession(true);
			session.setAttribute("user", username);
			//ProductsManager.getProcutsList();
			//SuppliersManager.getSuppliersList();
			response.sendRedirect("validLogin.jsp");
		}else{
			request.setAttribute("error", "Invalid user");
			request.getRequestDispatcher("invalidLogin.jsp");
		}
	}
}