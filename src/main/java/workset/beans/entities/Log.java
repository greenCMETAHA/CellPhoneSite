package workset.beans.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import workset.services.Service;
import workset.beans.interfaces.InterfaceLog;

@Entity
@Table( name = "log")
public class Log implements InterfaceLog{
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "time")
	private Date time;
	
	@ManyToOne
	private User user;
	
	@Column(name = "object")
	@Size(min=0, max=20)
	private String object;
	
	@Column(name = "object_id")
	@Size(min=0, max=45)
	private String objectId;
	
	@Size(min=0, max=100)
	@Column(name = "object_name")
	private String objectName;
	
	@Size(min = 0, max = 249)
	private String info;
	
	public Log(int id, User user, Date time, String object, String objectId, String objectName, String info) {
		super();
		this.id = id;
		this.user = user;
		this.time = time;
		this.object = object;
		this.objectId = objectId;
		this.objectName = objectName;
		setInfo(info);
	}
	
	public Log() {
		super();
		this.id = 0;
		this.user = new User();
		this.time = new Date();
		this.object = new String("<не определено>");
		this.objectId = "";
		this.objectName = "";
		
		this.info = "";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * @return the object
	 */
	public String getObject() {
		return object;
	}
	
	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getObjectName(){
		String result="<не определен>";
		
		if (object!=null){
			Class c=object.getClass();
			result=c.getSimpleName();
		}
		
		return result;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(String object) {
		this.object = object;
	}

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = Service.validateString(info,250);
	}	
	
}
