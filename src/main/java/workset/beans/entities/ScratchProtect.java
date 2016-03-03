package workset.beans.entities;

import workset.beans.interfaces.InterfaceScratchProtect;

public class ScratchProtect implements InterfaceScratchProtect {
	private int id;
	private String name;
	
	public ScratchProtect(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public ScratchProtect() {
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
