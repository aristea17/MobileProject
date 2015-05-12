package hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name="department")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column (name="d_id")
	private int d_id;
	
	@Column (name="d_name")
	private String d_name;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Users users;
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="needs",
				joinColumns={@JoinColumn(name="d_id")},
				inverseJoinColumns={@JoinColumn(name="p_id")})
	private Set<Products> products = new HashSet<Products>();
	
	//new
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="deptsup",
				joinColumns={@JoinColumn(name="d_id")},
				inverseJoinColumns={@JoinColumn(name="s_id")})
	private Set<Suppliers> suppliers = new HashSet<Suppliers>();
	//finish new
	 
	public Department(){}
	
	public Department(String department){
		this.d_name = department;
	}
	
	public Users getUser(){
		return users;
	}
	
	public void setUser(Users user){
		this.users = user;
	}
	
	public int getId(){
		return d_id;
	}
	
	public void setId(int d_id){
		this.d_id = d_id;
	}
	
	public String getName(){
		return d_name;
	}
	
	public void setName(String d_name){
		this.d_name = d_name;
	}
	
	public void setProducts(Set<Products> products){
		 this.products = products;
	}
	
	public Set<Products> getProducts(){
		return products;
	}
	
	//new
	public void setSuppliers(Set<Suppliers> suppliers){
		this.suppliers = suppliers;
	}
	
	public Set<Suppliers> getSuppliers(){
		return suppliers;
	}
	//finish new
}
