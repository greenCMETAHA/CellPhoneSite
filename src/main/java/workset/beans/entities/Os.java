package workset.beans.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import workset.beans.interfaces.InterfaceOS;

@Entity
@Table( name = "os")
public class Os implements InterfaceOS {
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name")
	@Size(min=0, max=45)
	private String name;
	
	public Os(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Os() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
