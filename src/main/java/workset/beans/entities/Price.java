package workset.beans.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import workset.beans.interfaces.InterfacePrice;
import workset.beans.interfaces.InterfaceUser;
import workset.beans.entities.User;

@Entity
@Table( name = "prices")
public class Price implements InterfacePrice{
	
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "time")
	private Date time;
	
	@Column(name = "price")
	private double price;

	@Column(name = "goodPrefix")
	@Size(min=3, max=3)
	private String goodPrefix;

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Phone phone;
	
	public Price(){
	}

	public Price(int id, Date date, double price, User user, String goodPrefix, Phone phone) {
		super();
		this.id = id;
		this.time = date;
		this.price = price;
		this.user = user;
		this.goodPrefix = goodPrefix;
		this.phone = phone;
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
