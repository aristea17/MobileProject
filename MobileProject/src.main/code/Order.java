package code;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Order {	
	private Hashtable<String, BuyProduct> order;
	private String supplier;
	private String email;
	
	/* Constructor */
	public Order(String supplier, String email){
		order = new Hashtable<String, BuyProduct>();
		this.supplier = supplier;
		this.email = email;
	}
	
	/* Getters */
	public String getSupplier(){
		return supplier;
	}
	
	public String getEMail(){
		return email;
	}
	
	/* Add product to this order
	 * IF product already exists we update quantity by summing them up
	 * ELSE we simply add it to the order */
	public void add(BuyProduct product){
		if(order.containsKey(product.getName())){
			int oldQuantity = order.get(product.getName()).getQuantity();
			order.get(product.getName()).setQuantity(product.getQuantity()+oldQuantity);
		}
		else{
			order.put(product.getName(), product);
		}
	}
	
	/* Removes given product from this order */
	public void remove(String productName){
		if(order.containsKey(productName)){
			order.remove(productName);
		}
	}
	
	/* Reduce given product's quantity by given value */
	public void reduce(String productName, int quantity){
		if(order.containsKey(productName)){
			BuyProduct p = order.get(productName);
			int result = p.getQuantity() - quantity;
			
			/* IF result is less or equal zero, we remove the given product from this order */
			if(result <= 0) remove(productName);
			else p.setQuantity(result);
		}
	}
	
	/* isEmpty method */
	public boolean isEmpty(){
		return order.isEmpty();
	}
	
	/* Returns a list of all products present in this Order  */
	public List<BuyProduct> getProductList(){	
		List<BuyProduct> myProducts = new ArrayList<BuyProduct>();
		
		if(!order.isEmpty()){
			for(BuyProduct p : order.values()){
				myProducts.add(p);
			}
		}
		
		return myProducts;
	}
	
	/* Gets all product in this order and calculate this order's total */
	public String getTotal(){
		double total = 0;
		
		if(!order.isEmpty()){
			for(BuyProduct product : order.values()){
				total += (product.getPrice()*product.getQuantity());
			}
		}
		
		String stringTotal = String.format("%.2f", total);
		return stringTotal;
	}
	
	/* Generates String content of this order to be printed in PDF whn generated */
	public String stringMyOrder(){
		String stringOrder = "";
		if(!order.isEmpty()){
			for(BuyProduct product : order.values()){
				stringOrder += "Product: " + product.getName() + "\t\tQuantity: " + product.getQuantity() + "\t\tPrice: " + product.getPrice() + "€"  +"\n";
			}
			stringOrder += "\n\n";
			stringOrder += "Total: " + getTotal() + "€\n";
		}
		return stringOrder;
	}
	
	// Debug method
	public void printMyOrder(){
		if(!order.isEmpty()){
			for(BuyProduct product : order.values()){
				System.out.println("product: "+product.getName() + "\tPrice: " + product.getPrice() + "\tQuantity: " + product.getQuantity());
			}
		}		
	}
	
}
