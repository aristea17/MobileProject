package code;

import hibernate.Suppliers;

public class BuyProduct {
	private String pName;
	private int quantity;
	private double price;
	private Suppliers supplier;
	
	public BuyProduct(String pName, int quantity, double price, Suppliers supplier){
		this.pName = pName;
		this.quantity = quantity;
		this.price = price;
		this.supplier = supplier;
	}

	public String getpName() {
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
	
	

}
