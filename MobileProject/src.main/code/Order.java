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
	
	public void remove(BuyProduct product){
		if(order.containsKey(product.getName())){
			order.remove(product.getName());
		}
	}
	
	public void remove(String product){
		if(order.containsKey(product)){
			order.remove(product);
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
	
	public double getTotal(){
		double total = 0;
		//DecimalFormat df = new DecimalFormat("#.##"); 
		
		if(!order.isEmpty()){
			for(BuyProduct product : order.values()){
				total += (product.getPrice()*product.getQuantity());
			}
		}
	     
		//total = Double.valueOf(df.format(total));
		
		return total;		
	}
	
	public String stringMyOrder(){
		String stringOrder = "";
		if(!order.isEmpty()){
			for(BuyProduct product : order.values()){
				stringOrder += "Product: "+product.getName() + "\t\tPrice: " + product.getPrice() + "\t\tQuantity: " + product.getQuantity()+"\n";
			}
			stringOrder += "\n\n";
			stringOrder += "Total: " + getTotal() + "\n";
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
