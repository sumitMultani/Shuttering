package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_received")
public class ItemReceived implements Serializable {

	private static final long serialVersionUID = -3414553065336245476L;

	@Column(name = "received_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long receivedId;

	@Column(name = "received_date")
	private String receivedDate;

	@Column(name = "transaction_type")
	private String transactionType;

	@Column(name = "challan_no")
	private String challanNo;

	@Column(name = "party_name")
	private String partyName;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "size")
	private String size;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "excess_quantity")
	private Integer excessQuantity;

	@Column(name = "breakage")
	private Integer breakage;

	@Column(name = "shortage")
	private Integer shortage;

	@Column(name = "square_feet")
	private String squareFeet;
	
	@Column(name = "site")
	private String site;
	
	@Column(name = "mobile")
	private String mobile;

	public ItemReceived() {
		// 0 - param constructor.
	}

	public ItemReceived(Long receivedId, String receivedDate,
			String transactionType, String challanNo, String partyName,
			String fatherName, String itemName, String size, Integer quantity,
			Integer excessQuantity, Integer breakage, Integer shortage,
			String squareFeet, String site, String mobile) {
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
		this.site = site;
		this.mobile = mobile;
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
	
	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
				+ squareFeet + ", site=" + site + ", mobile=" + mobile + "]";
	}

	 
}
