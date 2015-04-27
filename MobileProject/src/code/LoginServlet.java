package code;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		UserBean user = new UserBean();
		user.setUsername(req.getParameter("txtUsername"));
		user.setPassword(req.getParameter("txtPassword"));
		
		try {
			user = UserDAO.login(user);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		HttpSession session;
		if(user.isValid()){
			session = req.getSession(true);
			session.setAttribute("currentSessionUser", user);
			resp.sendRedirect("validLogin.jsp");
		}else{
			resp.sendRedirect("LoginPage.jsp");
		}
	}
}