package code;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		UserBean user = new UserBean();
		user.setUsername(req.getParameter("txtUsername"));
		user.setPassword(req.getParameter("txtPassword"));
		
		PrintWriter out = resp.getWriter();
		
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
			out.println("<div>Login error</div>");
			req.getRequestDispatcher("LoginPage.jsp").include(req, resp);
			
			//resp.sendRedirect("LoginPage.jsp");
		}
	}
}