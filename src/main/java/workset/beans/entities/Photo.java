package workset.beans.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import workset.beans.interfaces.InterfacePhoto;

@Entity
@Table( name = "photo")
public class Photo implements InterfacePhoto {
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name")
	@Size(min=0, max=150)
	private String name;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "ismain")
	private boolean isMain;
	
	@Column(name = "goodPrefix")
	@Size(min=3, max=3)
	private String goodPrefix;	
	
	@ManyToOne
	private Phone phone;
	
	public Photo(int id, String name, String comment, String goodPrefix, Phone phone) {
		super();
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.isMain = false;
		this.goodPrefix = goodPrefix;
		this.phone=phone;
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

	public String getGoodPrefix() {
		return goodPrefix;
	}

	public void setGoodPrefix(String goodPrefix) {
		this.goodPrefix = goodPrefix;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
}
