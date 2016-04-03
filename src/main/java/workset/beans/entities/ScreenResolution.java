package workset.beans.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import workset.beans.interfaces.InterfaceScreenResolution;

@Entity
@Table( name = "screenresolutions")
public class ScreenResolution implements InterfaceScreenResolution {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "resolution")
	@Size(min=0, max=45)
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
		this.resolution = name;
	}
}
