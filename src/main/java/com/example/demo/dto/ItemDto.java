package com.example.demo.dto;


/**
 * Created by ashish on 13/5/17.
 */
public class ItemDto {

	private Long itemId;
	private String itemName;
	private Integer length;
	private Integer width;
	private String squareFeet;
	private String size;
	private Integer rate;
	private String per;
	private Integer stock;
	private Integer rentPerDay;
	private Integer brokerCharges;
	private Integer received;
	private Integer issued;
	private Integer purchased;
	private Integer shortage;
	private Integer breakage;
	 

	public ItemDto() {

	}

	public ItemDto(Long itemId, String itemName, Integer length, Integer width,
			String size, Integer rate, String per, Integer stock,
			Integer rentPerDay, Integer brokerCharges, Integer received,
			Integer issued, Integer purchaed, Integer shortage, Integer breakage) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.length = length;
		this.width = width;
		this.size = size;
		this.rate = rate;
		this.per = per;
		this.stock = stock;
		this.rentPerDay = rentPerDay;
		this.brokerCharges = brokerCharges;
		this.received = received;
		this.issued = issued;
		this.purchased = purchaed;
		this.shortage = shortage;
		this.breakage = breakage;
		 
	}

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

	public Integer getBrokerCharges() {
		return brokerCharges;
	}

	public void setBrokerCharges(Integer brokerCharges) {
		this.brokerCharges = brokerCharges;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getBreakage() {
		return breakage;
	}

	public void setBreakage(Integer breakage) {
		this.breakage = breakage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDto other = (ItemDto) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemDto [itemId=" + itemId + ", itemName=" + itemName
				+ ", length=" + length + ", width=" + width + ", squareFeet="
				+ squareFeet + ", size=" + size + ", rate=" + rate + ", per="
				+ per + ", stock=" + stock + ", rentPerDay=" + rentPerDay
				+ ", brokerCharges=" + brokerCharges + ", received=" + received
				+ ", issued=" + issued + ", purchased=" + purchased
				+ ", shortage=" + shortage + ", breakage=" + breakage + "]";
	}
	
	
}
