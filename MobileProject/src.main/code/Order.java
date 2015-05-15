package code;

import hibernate.Suppliers;

import java.util.List;

public class Order {
	
	private List<BuyProduct> myOrder;
	String supplier;
	String email;
	
	public Order(Suppliers supplier){
		myOrder = null;
		this.supplier = supplier.getCompany();
		this.email = supplier.getEmail();
	}
	
	public void add(BuyProduct product){
		myOrder.add(product);
	}
	
	public List<BuyProduct> getProductList(){
		return myOrder;
	}
	
	public String getSupplier(){
		return supplier;
	}
	
	public String getEMail(){
		return email;
	}
	
	public void printMyOrder(){
		System.out.println(myOrder.toString());
	}

}
