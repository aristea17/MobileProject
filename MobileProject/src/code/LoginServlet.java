package code;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		UserBean user = new UserBean();
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		
		user = UserDAO.login(user);
		
		if(user.getValid()){
			HttpSession session = req.getSession(true);
			session.setAttribute("currentSessionUser", user);
			resp.sendRedirect("validLogin.jsp");
		}else{
			resp.sendRedirect("invalidLogin.jsp");
		}
	}

}
