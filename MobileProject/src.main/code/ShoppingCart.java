package code;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ShoppingCart {
	
	private static Hashtable<String, Order> cart = new Hashtable<String, Order>();
	private static Order newOrder = null;
	
	// Add product to cart
	public static void addToCart(BuyProduct product){
		// If there is already an order for the supplier of the selected product
		if(cart.containsKey(product.getSupplierName())){
			// We get the Order for that supplier and we add the product
			cart.get(product.getSupplierName()).add(product);
		}
		// Else we create a new Order for the "new" supplier in cart and we add the product,
		// then we add the Order in the cart
		else{
			newOrder = new Order(product.getSupplierName(), product.getSupplierEmail());
			newOrder.add(product);
			addOrder(newOrder);
		}
	}
	
	// PRIVATE Add Order to the "cart" HastTable
	private static void addOrder(Order order){
		cart.put(order.getSupplier(), order);
	}
	
	// 
	public static void remove(BuyProduct product){
		if(cart.containsKey(product.getSupplierName())){
			Order currentOrder = cart.get(product.getSupplierName());
			currentOrder.remove(product);
			if(currentOrder.isEmpty()){
				cart.remove(currentOrder.getSupplier());
			}
		}
	}
	
	public static void remove(String supplierName, String productName){
		if(cart.containsKey(supplierName)){
			Order currentOrder = cart.get(supplierName);
			currentOrder.remove(productName);
			if(currentOrder.isEmpty()){
				cart.remove(supplierName);
			}
		}
	}
	
	public static void update(String supplierName, String productName, int quantity){
		if(cart.containsKey(supplierName)){
			Order currentOrder = cart.get(supplierName);
			currentOrder.update(productName, quantity);
			if(currentOrder.isEmpty()){
				cart.remove(supplierName);
			}
		}
	}
	
	public static List<Order> getOrderList(){
		List<Order> ordersList = new ArrayList<Order>();
		if(!cart.isEmpty()){
			for(Order order : cart.values()){
				ordersList.add(order);
			}
		}
		return ordersList;
	}
	
	public static Order getOrderBySupplierName(String supplier){
		return cart.get(supplier);
	}
	
	public static Order getOrderBySupplierName(BuyProduct product){
		return cart.get(product.getSupplierName());
	}
	
	public static void clear(){
		cart.clear();
	}
	
	// for debug
	public static void printShoppingCartContent(){
		if(!cart.isEmpty()){
			for(String supplierName : cart.keySet()){
				System.out.println(supplierName);
			}
		}
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println();
	}
	
	public static void printOrdersContent(){
		if(!cart.isEmpty()){
			for(Order order : cart.values()){
				order.printMyOrder();
			}
		}
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println();
	}
		
}
