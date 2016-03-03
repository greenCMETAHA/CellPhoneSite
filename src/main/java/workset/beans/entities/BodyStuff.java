package workset.beans.entities;

import workset.beans.interfaces.InterfaceBodyStuff;

public class BodyStuff implements InterfaceBodyStuff {
	private int id;
	private String name;
	
	public BodyStuff(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public BodyStuff() {
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
