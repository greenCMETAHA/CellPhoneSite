package workset.beans.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import workset.beans.interfaces.InterfaceProcessor;

@Entity
@Table( name = "processor")
public class Processor implements InterfaceProcessor {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name")
	@Size(min=0, max=45)
	private String name;
	
	public Processor(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Processor() {
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
