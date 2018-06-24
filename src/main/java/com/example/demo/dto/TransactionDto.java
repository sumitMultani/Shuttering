package com.example.demo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class TransactionDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3875959887512291858L;
	
	private String date;
	private String voucher;
	private String partyName;
	private String fatherName;
	private String itemName;
	private String size;
	private Integer quantity;
	private String transactionType;
	private Integer breakage;
	private Integer shortage;
	private String site;
	private String remarks;
	 
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
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
	 
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	public String getVoucher() {
		return voucher;
	}
	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "TransactionDto [date=" + date + ", voucher=" + voucher
				+ ", partyName=" + partyName + ", fatherName=" + fatherName
				+ ", itemName=" + itemName + ", size=" + size + ", quantity="
				+ quantity + ", transactionType=" + transactionType
				+ ", breakage=" + breakage + ", shortage=" + shortage
				+ ", site=" + site + ", remarks=" + remarks + "]";
	}
	 
}
