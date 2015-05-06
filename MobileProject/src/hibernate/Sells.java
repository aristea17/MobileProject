package hibernate;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="sells")
@AssociationOverrides({
	@AssociationOverride(name="primaryKey.suppliers",
			joinColumns=@JoinColumn(name="s_id")),
	@AssociationOverride(name="primaryKey.products",
			joinColumns=@JoinColumn(name="p_id"))
})

public class Sells {
	//composite-id key
	private SupplierProductID primaryKey = new SupplierProductID();
	
	//additional fields 
	private double price;
	
	@EmbeddedId 
	public SupplierProductID getPrimaryKey(){
		return primaryKey;
	}
	
	public void setPrimaryKey(SupplierProductID primaryKey){
		this.primaryKey = primaryKey;
	}
	
	@Transient
	public Products getProduct(){
		return getPrimaryKey().getProducts();
	}
	
	public void setProduct(Products products){
		getPrimaryKey().setProducts(products);
	}
	
	@Transient
	public Suppliers getSupplier(){
		return getPrimaryKey().getSuppliers();
	}
	
	public void setSupplier(Suppliers suppliers){
		getPrimaryKey().setSuppliers(suppliers);;
	}
	
	@Column(name="price")
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
}