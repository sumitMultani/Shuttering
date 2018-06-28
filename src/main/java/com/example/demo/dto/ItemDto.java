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
	private Integer breakageCharges;
	 
	public ItemDto() {

	}

	public ItemDto(Long itemId, String itemName, Integer length, Integer width,
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

	public String getSquareFeet() {
		return squareFeet;
	}

	public void setSquareFeet(String squareFeet) {
		this.squareFeet = squareFeet;
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

	public Integer getBreakageCharges() {
		return breakageCharges;
	}

	public void setBreakageCharges(Integer breakageCharges) {
		this.breakageCharges = breakageCharges;
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
				+ ", breakageCharges=" + breakageCharges + "]";
	}
	
	
}
