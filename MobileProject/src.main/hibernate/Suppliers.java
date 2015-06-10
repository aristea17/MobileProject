package hibernate;

/* Hibernate class defining Suppliers table */

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

@Entity
@Table(name="suppliers")
public class Suppliers {
	
	@Expose private int s_id;
	@Expose private String company;
	private String email;
	private String rep_name;
	private String address;
	private String telephone;
	
	private Set<Sells> sells = new HashSet<Sells>();
	
	private Set<Department> department = new HashSet<Department>();
	
	/* Constructors */
	public Suppliers(){}
	
	public Suppliers(String company, String email, String rep_name, String address, String telephone){
		this.company = company;
		this.email = email;
		this.rep_name = rep_name; 
		this.address = address; 
		this.telephone = telephone;
	}
	
	@Id
	@GeneratedValue
	@Column (name="s_id")
	public int getID(){
		return s_id;
	}
	
	public void setID(int id){
		this.s_id = id;
	}
	
	@Column(name="company", nullable=false)
	public void setCompany(String company){
		this.company = company;
	}
	
	public String getCompany(){
		return company;
	}
	
	@Column(name="email", nullable=false)
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}
	
	@Column(name="rep_name")
	public void setRepresentative(String rep_name){
		this.rep_name = rep_name;
	}
	
	public String getRepresentative(){
		return rep_name;
	}
	
	@Column(name="address")
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return address;
	}
	
	@Column(name="telephone")
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
	
	public String getTelephone(){
		return telephone;
	}
	
	@OneToMany(mappedBy="primaryKey.suppliers")
	public Set<Sells> getSells(){
		return sells;
	}
	
	public void setSells(Set<Sells> sells){
		this.sells = sells;
	}	
	
	@ManyToMany(mappedBy="suppliers")
	public Set<Department> getDepartment(){
		return department;
	}
	
	public void setDepartment(Set<Department> department){
		this.department = department;
	}
}