package javaClasses;
 
import model.Products;
import model.Suppliers;

public class ProductTuple {

	private int p_id;
	private String p_name;
	private String p_batch_amount;
	private int p_minimum;
	private int p_stored;
	private String s_name;
	private String s_email;
	private double price;	
	
	/* Constructors */
	public ProductTuple(int p_id, String p_name, String p_batch_amount, int p_minimum, int p_stored,
			String s_name, String s_email, double price){
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_batch_amount = p_batch_amount;
		this.p_minimum = p_minimum;
		this.p_stored = p_stored;
		this.s_name = s_name;
		this.s_email = s_email;
		this.price = price;
	}
	
	public ProductTuple(Products p, Suppliers s, double price){
		this.p_id = p.getID();
		this.p_name = p.getName();
		this.p_batch_amount = p.getBatchAmount();
		this.p_minimum = p.getMinimum();
		this.p_stored = p.getStored();
		this.s_name = s.getCompany();
		this.s_email = s.getEmail();
		this.price = price;
	}

	/* Getters */
	public int getP_id() {
		return p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public String getP_batch_amount() {
		return p_batch_amount;
	}
	
	public int getP_minimum() {
		return p_minimum;
	}

	public int getP_stored() {
		return p_stored;
	}

	public String getS_name() {
		return s_name;
	}
	
	public String getS_email() {
		return s_email;
	}

	public double getPrice() {
		return price;
	}
}