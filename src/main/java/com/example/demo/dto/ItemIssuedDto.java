package com.example.demo.dto;

import java.io.Serializable;

public class ItemIssuedDto implements Serializable {

	private static final long serialVersionUID = -4084782824906747591L;

	private Long issueId;
	private String issuedDate;
	private String transactionType;
	private String challanNo;
	private String partyName;
	private String fatherName;
	private String itemName;
	private String size;
	private Integer quantity;
	private Integer excessQuantity;
	private String breakage;
	private String shortage;
	//private String squareFeet;

	public ItemIssuedDto() {
		// 0 - param constructor.
	}

	public ItemIssuedDto(Long issueId, String issuedDate,
			String transactionType, String challanNo, String partyName,
			String fatherName, String itemName, String size, Integer quantity,
			Integer excessQuantity, String breakage, String shortage,
			String squareFeet) {
		this.issueId = issueId;
		this.issuedDate = issuedDate;
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
		//this.squareFeet = squareFeet;
	}

	public Long getIssueId() {
		return issueId;
	}

	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
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

	public String getBreakage() {
		return breakage;
	}

	public void setBreakage(String breakage) {
		this.breakage = breakage;
	}

	public String getShortage() {
		return shortage;
	}

	public void setShortage(String shortage) {
		this.shortage = shortage;
	}

//	public String getSquareFeet() {
//		return squareFeet;
//	}
//
//	public void setSquareFeet(String squareFeet) {
//		this.squareFeet = squareFeet;
//	}

	@Override
	public String toString() {
		return "ItemIssuedDto [issueId=" + issueId + ", issuedDate="
				+ issuedDate + ", transactionType=" + transactionType
				+ ", challanNo=" + challanNo + ", partyName=" + partyName
				+ ", fatherName=" + fatherName + ", itemName=" + itemName
				+ ", size=" + size + ", quantity=" + quantity
				+ ", excessQuantity=" + excessQuantity + ", breakage="
				+ breakage + ", shortage=" + shortage +  "]";
	}

}
