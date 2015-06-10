package model;
 
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table (name="users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="u_id")
	private int u_id;
	
	@Column (name="username", nullable=false)
	private String username;
	
	@Column (name="psw", nullable=false)
	private String password;
	

	@Column (name="department_d_id", unique=true, nullable=false)
	@GeneratedValue (generator="gen")
	@GenericGenerator (name="gen", strategy="foreign", parameters=@Parameter(name="property", value="department"))
	private int foreignDepartmentID;
	
	@OneToOne(mappedBy="users", cascade=CascadeType.ALL)
	private Department department;
	
	/* Constructors */
	public Users(){
		
	}
	
	public Users(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	/* Getter & Setter for Department */
	public Department getDepartment(){
		return department;
	}
	
	public void setDepartment(Department dept){
		this.department = dept;
	}
	
	/* Getter & Setter for ID */
	public int getID(){
		return u_id;
	}
	
	public void setID(int id){
		this.u_id = id;
	}
	
	/* Getter & Setter for Username*/
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	/* Getter & Setter for Password*/
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
}