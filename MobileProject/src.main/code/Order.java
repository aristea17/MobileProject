package code;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Order {
	
	private Hashtable<String, BuyProduct> order;
	//private List<BuyProduct> myOrder;
	private String supplier;
	private String email;
	
	public Order(String supplier, String email){
		order = new Hashtable<String, BuyProduct>();
		//myOrder = new ArrayList<BuyProduct>();
		this.supplier = supplier;
		this.email = email;
	}
	
	public void add(BuyProduct product){

		//myOrder.add(product);

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
		
		return myOrder; // still fine in old version with list!
	}
	
	public String getSupplier(){
		return supplier;
	}
	
	public String getEMail(){
		return email;
	}
	
	// write to pdf
	public void printMyOrder(){
		/*
		for(BuyProduct product : myOrder){
			System.out.println("product: "+product.getName() + "\tPrice: " + product.getPrice() + "\tQuantity: " + product.getQuantity());
		}
		*/
		if(!order.isEmpty()){
			for(BuyProduct product : order.values()){
				System.out.println("product: "+product.getName() + "\tPrice: " + product.getPrice() + "\tQuantity: " + product.getQuantity());
			}
		}
		
	}

}
