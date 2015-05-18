package code;

import hibernate.Suppliers;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private List<BuyProduct> myOrder;
	String supplier;
	String email;
	
	public Order(Suppliers supplier){
		myOrder = new ArrayList<BuyProduct>();
		this.supplier = supplier.getCompany();
		this.email = supplier.getEmail();
	}
	
	public void add(BuyProduct product){
		myOrder.add(product);
	}
	
	// probably never used
	public List<BuyProduct> getProductList(){
		return myOrder;
	}
	
	public String getSupplier(){
		return supplier;
	}
	
	public String getEMail(){
		return email;
	}
	
	// write to pdf
	public void printMyOrder(){
		for(BuyProduct product : myOrder){
			System.out.println("product: "+product.getName() + "\t" + product.getPrice());
		}		
	}

}
