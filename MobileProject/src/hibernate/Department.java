package hibernate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	public Department(){
		
	}
	
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
}
