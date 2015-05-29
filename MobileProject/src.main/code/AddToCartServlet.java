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
		
		System.out.println("Received: " + p_name + " " + s_name + " " + s_email + " "+ price +" " + quantity); //
		
		BuyProduct p = new BuyProduct(p_name, quantity, price, s_name, s_email);
		
		System.out.println(p.getName()+"\t created"); //
		System.out.println("a1");  //
		
		ShoppingCart.addToCart(p);
		
		System.out.println(p.getName()+"\t added"); //
		// Debug!
		System.out.println("a2");//
		ShoppingCart.printShoppingCartContent();
		String b = "b";
		for(Order order : ShoppingCart.getOrderList()){
			System.out.println();
			System.out.println("SupName: " + order.getSupplier());
			order.printMyOrder();
			System.out.println(b);
			b = b+"b";
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(p_name + " added to Shopping Cart!");
	}

}
