package com.example.demo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class AgreementDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7254030952944627971L;

	private Long id;

	private String date;

	private Long aggrementNo;

	private String partyName;

	private String siteName;

	private String itemName;

	private String length;

	private Double rate;

	private String per;

	private Double rentPerDay;

	private String itemNameBreakage;

	private String itemSizeBreakage;

	private Double damageChargesPerPc;

	public AgreementDto(Long id, String date, Long aggrementNo, String partyName,
			String siteName, String itemName, String length, Double rate,
			String per, Double rentPerDay, String itemNameBreakage,
			String itemSizeBreakage, Double damageChargesPerPc) {
		this.id = id;
		this.date = date;
		this.aggrementNo = aggrementNo;
		this.partyName = partyName;
		this.siteName = siteName;
		this.itemName = itemName;
		this.length = length;
		this.rate = rate;
		this.per = per;
		this.rentPerDay = rentPerDay;
		this.itemNameBreakage = itemNameBreakage;
		this.itemSizeBreakage = itemSizeBreakage;
		this.damageChargesPerPc = damageChargesPerPc;
	}

	public AgreementDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getAggrementNo() {
		return aggrementNo;
	}

	public void setAggrementNo(Long aggrementNo) {
		this.aggrementNo = aggrementNo;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}

	public Double getRentPerDay() {
		return rentPerDay;
	}

	public void setRentPerDay(Double rentPerDay) {
		this.rentPerDay = rentPerDay;
	}

	public String getItemNameBreakage() {
		return itemNameBreakage;
	}

	public void setItemNameBreakage(String itemNameBreakage) {
		this.itemNameBreakage = itemNameBreakage;
	}

	public String getItemSizeBreakage() {
		return itemSizeBreakage;
	}

	public void setItemSizeBreakage(String itemSizeBreakage) {
		this.itemSizeBreakage = itemSizeBreakage;
	}

	public Double getDamageChargesPerPc() {
		return damageChargesPerPc;
	}

	public void setDamageChargesPerPc(Double damageChargesPerPc) {
		this.damageChargesPerPc = damageChargesPerPc;
	}

}
