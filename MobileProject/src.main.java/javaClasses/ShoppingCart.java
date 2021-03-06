package javaClasses;
 
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ShoppingCart {
	
	private static Hashtable<String, Order> cart = new Hashtable<String, Order>();
	private static Order newOrder = null;
	
	/* Add product to cart :
	 * IF there is already an order for the supplier of the selected product
	 * 	We get the Order for that supplier and we add the product
	 * ELSE we create a new Order for the "new" supplier in the cart and add
	 * 	the product, then add the Order in the cart */
	public static void addToCart(BuyProduct product){

		if(cart.containsKey(product.getSupplierName())){
			cart.get(product.getSupplierName()).add(product);
		}
		else{
			newOrder = new Order(product.getSupplierName(), product.getSupplierEmail());
			newOrder.add(product);
			addOrder(newOrder);
		}
	}
	
	/* PRIVATE Add Order to the "cart" HashTable */
	private static void addOrder(Order order){
		cart.put(order.getSupplier(), order);
	}
	
	/* Removes given product from a specific supplier
	 * IF it happens that that specific order ends up empty, we remove its entry from the cart */
	public static void remove(String supplierName, String productName){
		if(cart.containsKey(supplierName)){
			Order currentOrder = cart.get(supplierName);
			currentOrder.remove(productName);
			if(currentOrder.isEmpty()){
				cart.remove(supplierName);
			}
		}
	}
	
	/* Reduces given product's quantity given the supplier order by the specified quantity 
	 * IF it happens that that specific order ends up empty, we remove its entry from the cart */
	public static void reduce(String supplierName, String productName, int quantity){
		if(cart.containsKey(supplierName)){
			Order currentOrder = cart.get(supplierName);
			currentOrder.reduce(productName, quantity);
			if(currentOrder.isEmpty()){
				cart.remove(supplierName);
			}
		}
	}
	
	/* Getters */
	public static Order getOrderBySupplierName(String supplier){
		return cart.get(supplier);
	}
	
	public static Order getOrderBySupplierName(BuyProduct product){
		return cart.get(product.getSupplierName());
	}
	
	/* Return a List of all Order (divided by supplier) inside the cart */
	public static List<Order> getOrderList(){
		List<Order> ordersList = new ArrayList<Order>();
		if(!cart.isEmpty()){
			for(Order order : cart.values()){
				ordersList.add(order);
			}
		}
		return ordersList;
	}
	
	/* Check emptiness */
	public static boolean isEmpty(){
		return cart.isEmpty();
	}
	
	/* Clears cart - Clears HashTable*/
	public static void clear(){
		cart.clear();
	}
	
	/* For debugging purpose */
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
	
	/* For debugging purpose */
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
