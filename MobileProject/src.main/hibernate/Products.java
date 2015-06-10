package hibernate;

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
	
	@Id
	@GeneratedValue
	@Column(name="p_id")
	public int getID(){
		return p_id;
	}
	
	public void setID(int id){
		this.p_id = id;
	}
	
	@Column(name="p_name", nullable=false, unique=true)
	public String getName(){
		return p_name;
	}
	
	public void setName(String name){
		this.p_name = name;
	}
	
	@Column(name="category", nullable=false)
	public String getCategory(){
		return category;
	}
	
	public void setCategory(String category){
		this.category = category;
	}
	
	@Column(name="batch_amount", nullable=false)
	public String getBatchAmount(){
		return batch_amount;
	}
	
	public void setBatchAmount(String batch){
		this.batch_amount = batch;
	}
	
	@Column(name="minimum", nullable=false)
	public int getMinimum(){
		return minimum;
	}
	
	public void setMinimum(int min){
		this.minimum = min;
	}
	
	@Column(name="stored")
	public int getStored(){
		return stored;
	}
	
	public void setStored(int stored){
		this.stored = stored;
	}
	
	@OneToMany(mappedBy="primaryKey.products") 
	public Set<Sells> getSells(){
		return sells;
	}
	
	public void setSells(Set<Sells> sells){
		this.sells = sells;
	}
	
	@ManyToMany(mappedBy="products")
	public Set<Department> getDepartment(){
		return department;
	}
	
	public void setDepartment(Set<Department> department){
		this.department = department;
	}	
}