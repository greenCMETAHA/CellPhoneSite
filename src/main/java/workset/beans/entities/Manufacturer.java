package workset.beans.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import workset.services.Service;
import workset.beans.interfaces.InterfaceManufacturer;

@Entity
@Table( name = "manufacturer")
public class Manufacturer implements InterfaceManufacturer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2659594803343434546L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name")
	@Size(min = 0, max = 45)
	private String name;

	@Column(name = "fullname")
	@Size(min = 0, max = 150)
	private String fullName;


	//@Id
//	@Column(name = "country_id", insertable=false, updatable=false)
//	@Size(min = 0, max = 150)
//	private int countryId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=true)
	private Country country;
	
	public Manufacturer() {
		super();
		name=Service.EMPTY;
		fullName=name;
		country=new Country();
	}

	public Manufacturer(int id, String name, Country country) {
		super();
		this.id = id;
		name=(name.length()==0?Service.EMPTY:name);
		setName(name);
		setFullName(name);
		this.country = country;
	}
	
	public Manufacturer(int id, String name, String fullName, Country country) {
		super();
		this.id = id;
		name=(name.length()==0?Service.EMPTY:name);
		setName(fullName);
		setFullName(fullName);
		this.country = country;
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
		name=(name.length()==0?Service.EMPTY:name);
		this.name = Service.validateString(name,45);
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = Service.validateString(fullName,150);
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return (Country)country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	
}
