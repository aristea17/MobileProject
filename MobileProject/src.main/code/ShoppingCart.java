package code;

import java.util.Hashtable;

public class ShoppingCart {
	
	private static Hashtable<String, Order> suppliers = new Hashtable<String, Order>();
	
	public static void addOrder(Order order){
		suppliers.put(order.getSupplier(), order);
	}
	
	public static void removeOrder(Order order){
		suppliers.remove(order.getSupplier());
	}
	
	public static void sendEmails(){
		
	}
	
	public static void clear(){
		suppliers.clear();
	}
		
}
