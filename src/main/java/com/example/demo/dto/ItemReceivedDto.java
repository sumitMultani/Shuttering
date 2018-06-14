package com.example.demo.dto;

import java.io.Serializable;

public class ItemReceivedDto implements Serializable {


	private static final long serialVersionUID = 8395173002275143383L;

	private Long receivedId;
	private String receivedDate;
	private String transactionType;
	private String challanNo;
	private String partyName;
	private String fatherName;
	private String itemName;
	private String size;
	private Integer quantity;
	private Integer excessQuantity;
	private Integer breakage;
	private Integer shortage;
	private String squareFeet;

	public ItemReceivedDto() {
		// 0 - param constructor.
	}

	public ItemReceivedDto(Long receivedId, String receivedDate,
			String transactionType, String challanNo, String partyName,
			String fatherName, String itemName, String size, Integer quantity,
			Integer excessQuantity, Integer breakage, Integer shortage,
			String squareFeet) {
		this.receivedId = receivedId;
		this.receivedDate = receivedDate;
		this.transactionType = transactionType;
		this.challanNo = challanNo;
		this.partyName = partyName;
		this.fatherName = fatherName;
		this.itemName = itemName;
		this.size = size;
		this.quantity = quantity;
		this.excessQuantity = excessQuantity;
		this.breakage = breakage;
		this.shortage = shortage;
		this.squareFeet = squareFeet;
	}

	public Long getReceivedId() {
		return receivedId;
	}

	public void setReceivedId(Long receivedId) {
		this.receivedId = receivedId;
	}

	public String getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getExcessQuantity() {
		return excessQuantity;
	}

	public void setExcessQuantity(Integer excessQuantity) {
		this.excessQuantity = excessQuantity;
	}

	public Integer getBreakage() {
		return breakage;
	}

	public void setBreakage(Integer breakage) {
		this.breakage = breakage;
	}

	public Integer getShortage() {
		return shortage;
	}

	public void setShortage(Integer shortage) {
		this.shortage = shortage;
	}

	public String getSquareFeet() {
		return squareFeet;
	}

	public void setSquareFeet(String squareFeet) {
		this.squareFeet = squareFeet;
	}

	@Override
	public String toString() {
		return "ItemReceived [receivedId=" + receivedId + ", receivedDate="
				+ receivedDate + ", transactionType=" + transactionType
				+ ", challanNo=" + challanNo + ", partyName=" + partyName
				+ ", fatherName=" + fatherName + ", itemName=" + itemName
				+ ", size=" + size + ", quantity=" + quantity
				+ ", excessQuantity=" + excessQuantity + ", breakage="
				+ breakage + ", shortage=" + shortage + ", squareFeet="
				+ squareFeet + "]";
	}

}
