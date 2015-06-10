package code;

import hibernate.ProductManager;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ProductStockServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		/* Get the input fields values*/
		int sum = Integer.parseInt(request.getParameter("update")); 
		int id = Integer.parseInt(request.getParameter("id"));
		
		/* Update product quantity in DB */
		ProductManager.updateProductById(id, sum);
		
		/*
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Added to the DB!");
		*/
	}

}
