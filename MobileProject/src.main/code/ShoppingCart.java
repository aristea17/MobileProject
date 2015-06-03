package code;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	
	public static void remove(BuyProduct product){
		if(suppliers.containsKey(product.getSupplierName())){
			Order currentOrder = suppliers.get(product.getSupplierName());
			currentOrder.remove(product);
			if(currentOrder.isEmpty()){
				suppliers.remove(currentOrder.getSupplier());
			}
		}
	}
	
	public static void remove(String supplier, String product){
		if(suppliers.containsKey(supplier)){
			Order currentOrder = suppliers.get(supplier);
			currentOrder.remove(product);
			if(currentOrder.isEmpty()){
				suppliers.remove(currentOrder.getSupplier());
			}
		}
	}
	
	public static void update(String supplier, String product){
		if(suppliers.containsKey(supplier)){
			Order currentOrder = suppliers.get(supplier);
		}
	}
	
	public static List<Order> getOrderList(){
		List<Order> ordersList = new ArrayList<Order>();
		if(!suppliers.isEmpty()){
			for(Order order : suppliers.values()){
				ordersList.add(order);
			}
		}
		return ordersList;
	}
	
	public static Order getOrderBySupplierName(String supplier){
		return suppliers.get(supplier);
	}
	
	public static Order getOrderBySupplierName(BuyProduct product){
		return suppliers.get(product.getSupplierName());
	}
	
	public static void clear(){
		suppliers.clear();
	}
	
	// for debug
	public static void printShoppingCartContent(){
		if(!suppliers.isEmpty()){
			for(String supplierName : suppliers.keySet()){
				System.out.println(supplierName);
			}
		}
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println();
	}
	
	public static void printOrdersContent(){
		if(!suppliers.isEmpty()){
			for(Order order : suppliers.values()){
				order.printMyOrder();
			}
		}
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println();
	}
		
}
