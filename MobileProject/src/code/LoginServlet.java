package code;
import hibernate.Manager;
import hibernate.Users;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		String username =  req.getParameter("txtUsername");
		String password = req.getParameter("txtPassword");
		
		boolean valid = Manager.verifyUser(username, password);
		
		Users user = new Users(username, password);
		
		HttpSession session;
		if(valid){
			session = req.getSession(true);
			session.setAttribute("currentSessionUser", user);
			resp.sendRedirect("validLogin.jsp");
		}else{
			resp.sendRedirect("invalidLogin.jsp");
		}
	}
}