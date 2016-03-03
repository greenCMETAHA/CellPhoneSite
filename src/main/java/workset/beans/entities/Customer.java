package workset.beans.entities;

import javax.validation.constraints.Size;

import workset.Services.Service;

public class Customer {
	private int id;
	
	@Size(min = 0, max = 45)
	private String fullName;
	
	@Size(min = 0, max = 45)
	private String lastName;
	
	@Size(min = 0, max = 45)
	private String companyName;
	
	@Size(min = 0, max = 100)
	private String Address;
	
	@Size(min = 0, max = 45)
	private String town;
	
	@Size(min = 0, max = 45)
	private String zip;
	
	@Size(min = 0, max = 45)
	private String EMail;
	
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
