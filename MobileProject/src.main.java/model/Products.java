package model;
 
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/* Hibernate class defining Products table*/

@Entity
@Table(name="products")
public class Products {

	@Expose private int p_id;
	@Expose private String p_name;
	@Expose private String category;
	@Expose private String batch_amount;
	@Expose private int minimum;
	@Expose private int stored;
	 
	private Set<Sells> sells = new HashSet<Sells>();
	
	private Set<Department> department = new HashSet<Department>();
	
	/* Constructors */
	public Products(){}
	
	public Products(String name, String batch, int min, int stored){
		this.p_name = name;
		this.batch_amount = batch;
		this.minimum = min;
		this.stored = stored;
	}
	
	/* Getter & Setter for ID */
	@Id
	@GeneratedValue
	@Column(name="p_id")
	public int getID(){
		return p_id;
	}
	
	public void setID(int id){
		this.p_id = id;
	}
	
	/* Getter & Setter for p_name */
	@Column(name="p_name", nullable=false, unique=true)
	public String getName(){
		return p_name;
	}
	
	public void setName(String name){
		this.p_name = name;
	}
	
	/* Getter & Setter for category */
	@Column(name="category", nullable=false)
	public String getCategory(){
		return category;
	}
	
	public void setCategory(String category){
		this.category = category;
	}
	
	/* Getter & Setter for batch_amount */
	@Column(name="batch_amount", nullable=false)
	public String getBatchAmount(){
		return batch_amount;
	}
	
	public void setBatchAmount(String batch){
		this.batch_amount = batch;
	}
	
	/* Getter & Setter for minimum */
	@Column(name="minimum", nullable=false)
	public int getMinimum(){
		return minimum;
	}
	
	public void setMinimum(int min){
		this.minimum = min;
	}
	
	/* Getter & Setter for stored */
	@Column(name="stored")
	public int getStored(){
		return stored;
	}
	
	public void setStored(int stored){
		this.stored = stored;
	}
	
	/* Getter & Setter for all prices for a Product */
	@OneToMany(mappedBy="primaryKey.products") 
	public Set<Sells> getSells(){
		return sells;
	}
	
	public void setSells(Set<Sells> sells){
		this.sells = sells;
	}
	
	/* Getter & Setter for all Department for a Product */
	@ManyToMany(mappedBy="products")
	public Set<Department> getDepartment(){
		return department;
	}
	
	public void setDepartment(Set<Department> department){
		this.department = department;
	}	
}