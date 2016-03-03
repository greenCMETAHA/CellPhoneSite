package workset.beans.entities;

import workset.beans.interfaces.InterfaceProcessor;

public class Processor implements InterfaceProcessor {
	private int id;
	private String name;
	
	public Processor(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Processor() {
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
