package workset.beans.entities;

import workset.beans.interfaces.InterfacePhoneType;

public class PhoneType implements InterfacePhoneType {
	private int id;
	private String name;
	
	public PhoneType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public PhoneType() {
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
