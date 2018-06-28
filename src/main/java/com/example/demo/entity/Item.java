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
@Table(name = "stock_items")
public class Item implements Serializable {

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

	@Column(name = "square_feet")
	private String squareFeet;

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

	@Column(name = "breakage_charges")
	private Integer breakageCharges;
	
	

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

	public String getSquareFeet() {
		return squareFeet;
	}

	public void setSquareFeet(String squareFeet) {
		this.squareFeet = squareFeet;
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

	public Integer getBreakageCharges() {
		return breakageCharges;
	}

	public void setBreakageCharges(Integer breakageCharges) {
		this.breakageCharges = breakageCharges;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Item() {
		// 0-param constructor
	}

	public Item(Long itemId, String itemName, Integer length, Integer width,
			String squareFeet, String size, Integer rate, String per,
			Integer stock, Integer rentPerDay, Integer breakageCharges) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.length = length;
		this.width = width;
		this.squareFeet = squareFeet;
		this.size = size;
		this.rate = rate;
		this.per = per;
		this.stock = stock;
		this.rentPerDay = rentPerDay;
		this.breakageCharges = breakageCharges;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName
				+ ", length=" + length + ", width=" + width + ", squareFeet="
				+ squareFeet + ", size=" + size + ", rate=" + rate + ", per="
				+ per + ", stock=" + stock + ", rentPerDay=" + rentPerDay
				+ ", breakageCharges=" + breakageCharges + "]";
	}

}
