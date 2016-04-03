package workset.beans.entities;

import workset.beans.interfaces.InterfaceBasket;
import workset.beans.interfaces.base.InterfaceGood;

public class Basket implements InterfaceBasket {
	private InterfaceGood good;
	private double price;
	private int quantuty;
	
	public Basket() {
		super();
	}

	public Basket(InterfaceGood good, double price, int quantuty) {
		super();
		this.good = good;
		this.price = price;
		this.quantuty = quantuty;
	}

	public InterfaceGood getGood() {
		return good;
	}

	public void setGood(InterfaceGood good) {
		this.good = good;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantuty() {
		return quantuty;
	}

	public void setQuantuty(int quantuty) {
		this.quantuty = quantuty;
	}
}
