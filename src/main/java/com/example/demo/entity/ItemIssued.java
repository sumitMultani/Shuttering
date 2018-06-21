package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_issued")
public class ItemIssued implements Serializable {

	private static final long serialVersionUID = -3414553065336245476L;

	@Column(name = "issued_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long issueId;

	@Column(name = "issued_date")
	private String issuedDate;

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

	@Column(name = "square_feet")
	private String squareFeet;
	
	@Column(name = "site")
	private String site;
	
	@Column(name = "mobile")
	private String mobile;

	public ItemIssued() {
		// 0 - param constructor.
	}

	public ItemIssued(Long issueId, String issuedDate, String transactionType,
			String challanNo, String partyName, String fatherName,
			String itemName, String size, Integer quantity,
			Integer excessQuantity, 
			String squareFeet, String site, String mobile) {
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
		this.squareFeet = squareFeet;
		this.site = site;
		this.mobile = mobile;
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
		return "ItemIssued [issueId=" + issueId + ", issuedDate=" + issuedDate
				+ ", transactionType=" + transactionType + ", challanNo="
				+ challanNo + ", partyName=" + partyName + ", fatherName="
				+ fatherName + ", itemName=" + itemName + ", size=" + size
				+ ", quantity=" + quantity + ", excessQuantity="
				+ excessQuantity + ", squareFeet=" + squareFeet + ", site="
				+ site + ", mobile=" + mobile + "]";
	}
	 
}
