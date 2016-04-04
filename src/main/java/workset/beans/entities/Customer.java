package workset.beans.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import workset.services.Service;

@Entity
@Table( name = "customers")
public class Customer {
	
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "fullname")
	@Size(min = 0, max = 45)
	private String fullName;
	
	@Column(name = "lastname")
	@Size(min = 0, max = 45)
	private String lastName;
	
	@Column(name = "companyname")
	@Size(min = 0, max = 45)
	private String companyName;
	
	@Column(name = "address")
	@Size(min = 0, max = 100)
	private String Address;
	
	@Column(name = "town")
	@Size(min = 0, max = 45)
	private String town;
	
	@Column(name = "zip")
	@Size(min = 0, max = 45)
	private String zip;
	
	@Column(name = "email")
	@Size(min = 0, max = 45)
	private String EMail;
	
	@Column(name = "phone")
	@Size(min = 0, max = 30)
	private String phone;
	
	public Customer() {
		id=Service.ID_EMPTY_CUSTOMER;
	}
	
	public Customer(int id) {
		this.id=id;
	}	
	
	public Customer(int id, String fullName, String lastName, String companyName, String address, String town,
			String zip, String eMail, String phone) {
		super();
		this.id = id;
		setFullName(fullName);
		setLastName(lastName);
		setCompanyName(companyName);
		setAddress(address);
		setTown(town);
		setZip(zip);
		setEMail(eMail);
		setPhone(phone);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = Service.validateString(fullName,45);
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = Service.validateString(lastName,45);
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = Service.validateString(companyName,45);
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = Service.validateString(address,100);
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = Service.validateString(town,45);
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = Service.validateString(zip,45);
	}
	public String getEMail() {
		return EMail;
	}
	public void setEMail(String eMail) {
		EMail = Service.validateString(eMail,45);
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = Service.validateString(phone,30);
	}
	
	

}
