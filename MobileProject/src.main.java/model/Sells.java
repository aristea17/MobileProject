package model;
 
/* Hibernate class defining Sells table */

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="sells")
@AssociationOverrides({
	@AssociationOverride(name="primaryKey.suppliers",
			joinColumns=@JoinColumn(name="s_id")),
	@AssociationOverride(name="primaryKey.products",
			joinColumns=@JoinColumn(name="p_id"))
})

public class Sells {
	/* composite-id key */
	private SupplierProductID primaryKey = new SupplierProductID();
	
	/* additional fields */
	@Expose private double price;
	
	/* Getter & Setter for composite-id key */
	@EmbeddedId 
	public SupplierProductID getPrimaryKey(){
		return primaryKey;
	}
	
	public void setPrimaryKey(SupplierProductID primaryKey){
		this.primaryKey = primaryKey;
	}
	
	/* Getter & Setter for a Product */
	@Transient
	public Products getProduct(){
		return getPrimaryKey().getProducts();
	}
	
	public void setProduct(Products products){
		getPrimaryKey().setProducts(products);
	}
	
	/* Getter & Setter for a Supplier */
	@Transient
	public Suppliers getSupplier(){
		return getPrimaryKey().getSuppliers();
	}
	
	public void setSupplier(Suppliers suppliers){
		getPrimaryKey().setSuppliers(suppliers);;
	}
	
	/* Getter & Setter for Price */
	@Column(name="price")
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
}