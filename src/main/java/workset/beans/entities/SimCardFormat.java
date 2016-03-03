package workset.beans.entities;

import workset.beans.interfaces.InterfaceSIMCardFormat;

public class SimCardFormat implements InterfaceSIMCardFormat{
	
	private int id;
	private String name;
	
	public SimCardFormat(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public SimCardFormat() {
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
