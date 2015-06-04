package code;

import hibernate.Products;
import hibernate.Suppliers;

// BuyProduct class is for ShoppingCart only
public class BuyProduct {
	private String pName;
	private int quantity;
	private double price;
	private String supplierName;
	private String email;
	
	public BuyProduct(String pName, int quantity, double price, String supplierName, String email){
		this.pName = pName;
		this.quantity = quantity;
		this.price = price;
		this.supplierName = supplierName;
		this.email = email;
	}
	
	// Getters
	public String getName() {
		return pName;
	}

	public int getQuantity() {
		return quantity;
	}

	// setQuantity is the only Setter, in order to update quantity to buy of specific obj
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}
	
	public String getSupplierName(){
		return supplierName;
	}
	
	public String getSupplierEmail(){
		return email;
	}
}
