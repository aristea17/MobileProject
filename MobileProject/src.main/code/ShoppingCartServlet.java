package code;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShoppingCartServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String p_name = request.getParameter("pName");
		String s_name = request.getParameter("sName");
		//System.out.println("Product name before ShC.remove: "+p_name);
		//System.out.println("Sup name before ShC.remove: "+s_name);
		ShoppingCart.remove(s_name, p_name);
		//System.out.println("Product name after ShC.remove: "+p_name);
		//System.out.println("Sup name after ShC.remove: "+s_name);
	}
	
}
