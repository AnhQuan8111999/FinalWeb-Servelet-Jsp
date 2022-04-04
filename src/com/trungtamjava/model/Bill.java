package com.trungtamjava.model;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable {
	private int id;
	private User buyer;// nguoi mua
	private Date buyDate;// ngay mua
	private long priceTotal;// tong tien

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public long getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(long priceTotal) {
		this.priceTotal = priceTotal;
	}
}
