package hibernate;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class SupplierProductID implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Products products;
	private Suppliers suppliers;
	
	@ManyToOne
	public Products getProducts(){
		return products;
	}
	
	public void setProducts(Products products){
		this.products = products;
	}
	
	@ManyToOne
	public Suppliers getSuppliers(){
		return suppliers;
	}
	
	public void setSuppliers(Suppliers suppliers){
		this.suppliers = suppliers;
	}
}