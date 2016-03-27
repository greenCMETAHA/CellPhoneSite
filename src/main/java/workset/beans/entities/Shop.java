package workset.beans.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import workset.beans.interfaces.InterfaceShop;

@Entity
@Table( name = "shop")
public class Shop implements InterfaceShop{
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name")
	@Size(min=0, max=45)
	private String name;
	
	@Column(name = "description")
	@Size(min=0, max=200)
	private String description;
	
	@Column(name = "mapx")
	private double mapX;
	
	@Column(name = "mapy")
	private double mapY;
	
	public Shop() {
		super();
	}

	public Shop(int id, String name, String description, double mapX, double mapY) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.mapX = mapX;
		this.mapY = mapY;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMapX() {
		return mapX;
	}

	public void setMapX(double mapX) {
		this.mapX = mapX;
	}

	public double getMapY() {
		return mapY;
	}

	public void setMapY(double mapY) {
		this.mapY = mapY;
	}
	

}
