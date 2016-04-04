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
@Table(name = "country")
public class Country implements workset.beans.interfaces.InterfaceCountry {
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name")
	@Size(min=0, max=45)
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
	
	
	public String toString(){
		
		return ""+getId()+", "+getName();
	}

}
