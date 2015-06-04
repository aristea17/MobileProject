package code;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Order {
	
	private Hashtable<String, BuyProduct> order;
	private String supplier;
	private String email;
	
	public Order(String supplier, String email){
		order = new Hashtable<String, BuyProduct>();
		this.supplier = supplier;
		this.email = email;
	}
	
	public void add(BuyProduct product){
		if(order.containsKey(product.getName())){
			int oldQuantity = order.get(product.getName()).getQuantity();
			order.get(product.getName()).setQuantity(product.getQuantity()+oldQuantity);
		}
		else{
			order.put(product.getName(), product);
		}
	}
	
	//not used
	public void remove(BuyProduct product){
		if(order.containsKey(product.getName())){
			order.remove(product.getName());
		}
	}
	
	public void remove(String productName){
		if(order.containsKey(productName)){
			order.remove(productName);
		}
	}
	
	public void update(String productName, int quantity){
		if(order.containsKey(productName)){
			BuyProduct p = order.get(productName);
			int update = p.getQuantity() - quantity;
			
			if(update <= 0) remove(productName);
			else p.setQuantity(update);
		}
	}
	
	public boolean isEmpty(){
		return order.isEmpty();
	}
	
	// probably never used
	public List<BuyProduct> getProductList(){
		
		List<BuyProduct> myOrder = new ArrayList<BuyProduct>();
		
		if(!order.isEmpty()){
			for(BuyProduct p : order.values()){
				myOrder.add(p);
			}
		}
		
		return myOrder;
	}
	
	public String getSupplier(){
		return supplier;
	}
	
	public String getEMail(){
		return email;
	}
	
	public String getTotal(){
		double total = 0;
		//DecimalFormat df = new DecimalFormat("#.00"); 
		
		if(!order.isEmpty()){
			for(BuyProduct product : order.values()){
				total += (product.getPrice()*product.getQuantity());
			}
		}
		//total = Double.parseDouble(df.format(total));
		String result = String.format("%.2f", total);
		return (result);
	}
	
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
	
	// Debug
	public void printMyOrder(){
		if(!order.isEmpty()){
			for(BuyProduct product : order.values()){
				System.out.println("product: "+product.getName() + "\tPrice: " + product.getPrice() + "\tQuantity: " + product.getQuantity());
			}
		}
		
	}

}
