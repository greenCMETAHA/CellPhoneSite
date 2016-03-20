package workset.beans.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import workset.beans.interfaces.InterfacePhoto;

@Entity
@Table( name = "photo")
public class Photo implements InterfacePhoto {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name")
	@Size(min=0, max=150)
	private String name;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "ismain")
	private boolean isMain;
	
	public Photo(int id, String name, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.isMain = false;
	}
	
	public Photo(int id, String name, String comment, boolean isMain) {
		super();
		this.id = id;
		this.name = name;
		this.isMain = isMain;
	}	
	
	public Photo() {
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isMain() {
		return isMain;
	}

	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}
}
