package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agreement")
public class Agreement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7254030952944627971L;

	@Column(name = "agreement_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	@Column(name = "createdOn")
	private String date;

	@Column(name = "agreement_no")
	private Long aggrementNo;

	@Column(name = "party_name")
	private String partyName;

	@Column(name = "site_name")
	private String siteName;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "length")
	private String length;

	@Column(name = "rate")
	private Double rate;

	@Column(name = "per")
	private String per;

	@Column(name = "rent_per_day")
	private Double rentPerDay;

	@Column(name = "item_name_breakage")
	private String itemNameBreakage;

	@Column(name = "item_size_breakage")
	private String itemSizeBreakage;

	@Column(name = "damage_charges_per_pc")
	private Double damageChargesPerPc;

	public Agreement(Long id, String date, Long aggrementNo, String partyName,
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

	public Agreement() {

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
