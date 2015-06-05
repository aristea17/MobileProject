package code;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession(false);
		if(session!=null){
			ShoppingCart.clear(); //clears the shopping cart 
			session.removeAttribute("user");
			session.invalidate();
		}
		response.sendRedirect("login.jsp");
	}
}
