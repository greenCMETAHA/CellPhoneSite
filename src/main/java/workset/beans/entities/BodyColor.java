package workset.beans.entities;

import workset.beans.interfaces.InterfaceBodyColor;

public class BodyColor implements InterfaceBodyColor {
	private int id;
	private String name;
	
	public BodyColor(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public BodyColor() {
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
