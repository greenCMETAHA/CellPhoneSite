package workset.beans.entities;

import workset.beans.interfaces.InterfacePhoto;

public class Photo implements InterfacePhoto {
	private int id;
	private String name;
	private String comment;
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
