package workset.beans.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import workset.beans.interfaces.InterfacePrice;
import workset.beans.interfaces.InterfaceUser;
import workset.beans.entities.User;

@Entity
@Table( name = "prices")
public class Price implements InterfacePrice{
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "time")
	private Date time;
	
	@Column(name = "price")
	private double price;

	@ManyToOne
	private User user;
	
	public Price(){
	}

	public Price(int id, Date date, double price, User user) {
		super();
		this.id = id;
		this.time = date;
		this.price = price;
		this.user = user;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	public String showDate() {
		return time.toLocaleString();
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * @return the user
	 */
	public InterfaceUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
