package workset.beans.entities;

import workset.beans.interfaces.InterfaceScreenTechnology;

public class ScreenTechnology implements InterfaceScreenTechnology {
	private int id;
	private String name;
	
	public ScreenTechnology(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public ScreenTechnology() {
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
