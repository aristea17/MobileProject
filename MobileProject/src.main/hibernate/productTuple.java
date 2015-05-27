package hibernate;

import com.google.gson.annotations.Expose;

public class productTuple {

	private int p_id; // ? do we need this in the table ?
	private String p_name;
	private String p_batch_amount;
	private int p_minimum;
	private int p_stored;
	private String s_name;
	private double price;	
	
	productTuple(int p_id, String p_name, String p_batch_amount, int p_minimum, int p_stored,
			String s_name, double price){
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_batch_amount = p_batch_amount;
		this.p_minimum = p_minimum;
		this.p_stored = p_stored;
		this.s_name = s_name;
		this.price = price;
	}
	
	productTuple(Products p, Suppliers s, double price){
		this.p_id = p.getID();
		this.p_name = p.getName();
		this.p_batch_amount = p.getBatchAmount();
		this.p_minimum = p.getMinimum();
		this.p_stored = p.getStored();
		this.s_name = s.getCompany();
		this.price = price;
	}

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

	public double getPrice() {
		return price;
	}
	
	
	
}
