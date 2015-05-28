package code;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddToCartServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String p_name = request.getParameter("pName");
		String s_name = request.getParameter("sName");
		String s_email = request.getParameter("sEmail");
		double price = Double.parseDouble(request.getParameter("pPrice"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		// To do - create BuyProduct and add to cart
		BuyProduct p = new BuyProduct(p_name, quantity, price, s_name, s_email);
		ShoppingCart.addToCart(p);
		
		// Debug!
		ShoppingCart.printShoppingCartContent();
		for(Order order : ShoppingCart.getOrderList()){
			System.out.println();
			System.out.println("SupName: " + order.getSupplier());
			order.printMyOrder();
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(p_name + " added to Shopping Cart!");
	}

}
