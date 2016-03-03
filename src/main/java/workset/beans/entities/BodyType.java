package workset.beans.entities;

import workset.beans.interfaces.InterfaceBodyType;

public class BodyType implements  InterfaceBodyType {
	private int id;
	private String name;
	
	public BodyType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public BodyType() {
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
