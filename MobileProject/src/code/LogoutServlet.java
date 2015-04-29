package code;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		session.invalidate();
		
		
	}

}
