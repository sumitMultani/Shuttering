package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by sumit
 */
@Entity
@Table(name = "stock_status")
public class ItemStatus implements Serializable {

	private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;

	@Column(name = "items_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long itemId;

	@Column(name = "items_name")
	private String itemName;

	@Column(name = "length")
	private Integer length;

	@Column(name = "width")
	private Integer width;

	@Column(name = "size")
	private String size;

	@Column(name = "rate")
	private Integer rate;

	@Column(name = "pc")
	private String per;

	@Column(name = "stock")
	private Integer stock;

	@Column(name = "rent_per_day")
	private Integer rentPerDay;
	
	@Column(name = "received")
	private Integer received;

	@Column(name = "issued")
	private Integer issued;
	
	@Column(name = "purchased")
	private Integer purchased;

	@Column(name = "shortage")
	private Integer shortage;
	
	@Column(name = "breakage")
	private Integer breakage;
	 

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}

	public Integer getRentPerDay() {
		return rentPerDay;
	}

	public void setRentPerDay(Integer rentPerDay) {
		this.rentPerDay = rentPerDay;
	}
	
	public Integer getReceived() {
		return received;
	}

	public void setReceived(Integer received) {
		this.received = received;
	}

	public Integer getIssued() {
		return issued;
	}

	public void setIssued(Integer issued) {
		this.issued = issued;
	}

	public Integer getPurchased() {
		return purchased;
	}

	public void setPurchased(Integer purchased) {
		this.purchased = purchased;
	}

	public Integer getShortage() {
		return shortage;
	}

	public void setShortage(Integer shortage) {
		this.shortage = shortage;
	}
 
	public Integer getBreakage() {
		return breakage;
	}

	public void setBreakage(Integer breakage) {
		this.breakage = breakage;
	}
	
	public ItemStatus() {
		// 0-param constructor
	}

	public ItemStatus(Long itemId, String itemName, Integer length, Integer width,
			String size, Integer rate, String per, Integer stock,
			Integer rentPerDay, Integer brokerCharges, 
			Integer received, Integer issued, Integer purchased, Integer shortage, Integer breakage ) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.length = length;
		this.width = width;
		this.size = size;
		this.rate = rate;
		this.per = per;
		this.stock = stock;
		this.rentPerDay = rentPerDay;
		this.received = received;
		this.issued = issued;
		this.purchased = purchased;
		this.shortage = shortage;
		this.breakage = breakage;
	}

	@Override
	public String toString() {
		return "ItemStatus [itemId=" + itemId + ", itemName=" + itemName
				+ ", length=" + length + ", width=" + width + ", size=" + size
				+ ", rate=" + rate + ", per=" + per + ", stock=" + stock
				+ ", rentPerDay=" + rentPerDay + " , received=" + received + ", issued="
				+ issued + ", purchased=" + purchased + ", shortage="
				+ shortage + ", breakage=" + breakage + "]";
	}

	 

	 
}
