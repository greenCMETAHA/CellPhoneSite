package workset.beans.entities;

import javax.validation.constraints.Size;

import workset.Services.Service;
import workset.beans.interfaces.InterfaceCountry;

public class Country implements workset.beans.interfaces.InterfaceCountry {
	private int id;
	
	@Size(min = 0, max = 45)
	private String name;
	
	public Country() {
		name=Service.EMPTY;
	}

	public Country(int id, String name) {
		super();
		this.id = id;
		name=(name.length()==0?Service.EMPTY:name);
		setName(name);
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
	

}
