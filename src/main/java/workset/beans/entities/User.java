package workset.beans.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import workset.services.Service;
import workset.beans.interfaces.InterfaceRole;
import workset.beans.interfaces.InterfaceUser;

@Entity
@Table( name = "users")
public class User implements InterfaceUser{
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name")
	@Size(min=0, max=45)
	private String name;
	
	@Column(name = "email")
	@Size(min = 0, max = 45)
	private String email;
	
	@Column(name = "login")
	@Size(min = 0, max = 45)
	private String login;
	
	@Column(name = "password")
	@Size(min = 0, max = 45)
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usertable"
		, joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }
		, inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) })	
	private Set<Role> role;
	
	public User(){
		id=0;
		name="";
		email="";
		login="";
		password="";
		role = new HashSet<Role>();
	}
	
	public User(int id, String name, String email, String login, String password, Role role) {
		super();
		this.id = id;
		setName(name);
		setEmail(email);
		setLogin(login);
		setPassword(password);
		this.role = new HashSet<Role>();
		this.role.add(role);
	}

	public User(int id, String name, String email, String login, String password, HashSet<Role> role) {
		super();
		this.id = id;
		setName(name);
		setEmail(email);
		setLogin(login);
		setPassword(password);
		this.role = role;
	}
	
	
	public User(int id, String name, String email, String login) {
		super();
		this.id = id;
		setName(name);
		setEmail(email);
		setLogin(login);
	}	
	
	public User(String login, String password) {
		super();
		setLogin(login);
		setPassword(password);
	}	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = Service.validateString(name,45);
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = Service.validateString(email,45);
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = Service.validateString(login,45);
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = Service.validateString(password,45);
	}
	
	/**
	 * @return the role
	 */
	public Set<Role> getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(InterfaceRole role) {
		this.role.add((Role) role);
	}
	
	public void setRole(HashSet<Role> role) {
		this.role=role;
	}
		
	
	public boolean isEmpty(){
		boolean result=false;
		
		result=(name.length()>0?false:true);
		
		return result; 
	}
	
		

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", login=" + login + "]";
	}
}
