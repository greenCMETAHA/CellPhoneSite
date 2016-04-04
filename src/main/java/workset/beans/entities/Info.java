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
@Table( name = "information")
public class Info implements workset.beans.interfaces.InterfaceInfo{
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name")
	@Size(min = 0, max = 20)
	private String name;
	
	@Column(name = "value")
	@Size(min = 0, max = 100)
	private String value;
	
	public Info() {
		id=0;
	}
	public Info(int id, String name, String value) {
		super();
		this.id = id;
		setName(name);
		setValue(value);
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
		this.name = Service.validateString(name,20);
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = Service.validateString(value,100);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Info [id=" + id + ", name=" + name + ", value=" + value + "]";
	}
	
	
	
	

}
