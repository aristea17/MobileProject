package code;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
	
	private static Hashtable<String, Order> suppliers = new Hashtable<String, Order>();
	private static Order newOrder = null;
	//private static Order randomOrder = null;
	
	public static void addToCart(BuyProduct product){
		if(suppliers.containsKey(product.getSupplierName())){
			suppliers.get(product.getSupplierName()).add(product);
		}
		else{
			newOrder = new Order(product.getSupplierName(), product.getSupplierEmail());
			newOrder.add(product);
			addOrder(newOrder);
		}
	}
	
	private static void addOrder(Order order){
		suppliers.put(order.getSupplier(), order);
	}
	
	public static void removeOrder(Order order){
		suppliers.remove(order.getSupplier());
	}
	
	public static List<Order> getOrderList(){
		List<Order> orders = new ArrayList<Order>();
		for(Map.Entry<String,Order> entry : suppliers.entrySet()){
			orders.add(entry.getValue());
		}
		return orders;
	}
	
	public static Order getOrderBySupplierName(String supplier){
		return suppliers.get(supplier);
	}
	
	// for debug
	public static void printShoppingCartContent(){
		if(!suppliers.isEmpty()){
			for(Map.Entry<String,Order> entry : suppliers.entrySet()){
				System.out.println(entry.getKey());
			}
		}
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println();
	}
	
	// rename in "buy"
	public static void sendEmails(){
		
		//clear();
	}
	
	public static void clear(){
		suppliers.clear();
	}
		
}
