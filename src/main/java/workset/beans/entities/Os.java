package workset.beans.entities;

import workset.beans.interfaces.InterfaceOS;

public class Os implements InterfaceOS {
	private int id;
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
