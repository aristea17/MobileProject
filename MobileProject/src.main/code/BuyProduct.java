package code;

import hibernate.Products;
import hibernate.Suppliers;

public class BuyProduct {
	//private Products product;
	private String pName;
	private int quantity;
	private double price;
	private Suppliers supplier;
	
	/*public BuyProduct(String pName, int quantity, double price, Suppliers supplier){
		this.pName = pName;
		this.quantity = quantity;
		this.price = price;
		this.supplier = supplier;
	}*/
	
	/*public BuyProduct(Products product, Suppliers supplier, double price){
		this.product = product;
		this.pName = product.getName();
		this.quantity = 0;
		this.price = price;
		this.supplier = supplier;
	}
	
	public Products getProduct(){
		return product;
	} */
	
	public String getName() {
		return pName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public Suppliers getSupplier() {
		return supplier;
	}
	
	public String getSupplierName(){
		return supplier.getCompany();
	}
	
	public String getSupplierEmail(){
		return supplier.getEmail();
	}
	
	

}
