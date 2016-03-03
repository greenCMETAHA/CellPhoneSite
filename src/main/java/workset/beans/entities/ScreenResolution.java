package workset.beans.entities;

import workset.beans.interfaces.InterfaceScreenResolution;

public class ScreenResolution implements InterfaceScreenResolution {
	private int id;
	private String resolution;
	
	public ScreenResolution(int id, String resolution) {
		super();
		this.id = id;
		this.resolution = resolution;
	}
	
	public ScreenResolution() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getResolution() {
		return resolution;
	}
	
	public void setResolution(String name) {
		this.resolution = resolution;
	}
}
