package workset.beans.entities;

import workset.beans.interfaces.InterfaceBatteryType;

public class BatteryType implements  InterfaceBatteryType {
	private int id;
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
