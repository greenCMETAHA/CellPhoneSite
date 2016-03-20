package workset.beans.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import workset.beans.interfaces.InterfaceBatteryType;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "batterytype")
public class BatteryType implements InterfaceBatteryType {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name")
	@Size(min=0, max=45)
	private String name;
	
	public BatteryType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public BatteryType() {
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
