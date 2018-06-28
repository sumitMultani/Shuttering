package com.example.demo.dto;


public class ItemStatusDto {

	private Long itemId;

	private String itemName;

	private Integer length;

	private Integer width;

	private String size;

	private Integer rate;

	private String per;

	private Integer stock;

	private Integer rentPerDay;
	
	private Integer received;

	private Integer issued;
	
	private Integer purchased;

	private Integer shortage;
	
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
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

	public ItemStatusDto() {
	}

	public ItemStatusDto(Long itemId, String itemName, Integer length,
			Integer width, String size, Integer rate, String per,
			Integer stock, Integer rentPerDay, Integer received,
			Integer issued, Integer purchased, Integer shortage,
			Integer breakage) {
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
		return "ItemStatusDto [itemId=" + itemId + ", itemName=" + itemName
				+ ", length=" + length + ", width=" + width + ", size=" + size
				+ ", rate=" + rate + ", per=" + per + ", stock=" + stock
				+ ", rentPerDay=" + rentPerDay + ", received=" + received
				+ ", issued=" + issued + ", purchased=" + purchased
				+ ", shortage=" + shortage + ", breakage=" + breakage + "]";
	}

}
