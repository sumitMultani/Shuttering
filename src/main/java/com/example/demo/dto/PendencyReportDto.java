package com.example.demo.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class PendencyReportDto.
 */
public class PendencyReportDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 271705226461160840L;
	
	/** The party name. */
	private String partyName;
	
	/** The father name. */
	private String fatherName;
	
	/** The item name. */
	private String itemName;
	
	/** The size. */
	private String size;
	
	/** The quantity. */
	private Integer quantity;
	
	/** The site. */
	private String site;
	
	/** The mobile. */
	private String mobile;
	
	/**
	 * Gets the party name.
	 *
	 * @return the party name
	 */
	public String getPartyName() {
		return partyName;
	}
	
	/**
	 * Sets the party name.
	 *
	 * @param partyName the new party name
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	
	/**
	 * Gets the father name.
	 *
	 * @return the father name
	 */
	public String getFatherName() {
		return fatherName;
	}
	
	/**
	 * Sets the father name.
	 *
	 * @param fatherName the new father name
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Sets the item name.
	 *
	 * @param itemName the new item name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	
	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(String size) {
		this.size = size;
	}
	
	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	
	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Gets the site.
	 *
	 * @return the site
	 */
	public String getSite() {
		return site;
	}

	/**
	 * Sets the site.
	 *
	 * @param site the new site
	 */
	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * Gets the mobile.
	 *
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Sets the mobile.
	 *
	 * @param mobile the new mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "PendencyReportDto [partyName=" + partyName + ", fatherName="
				+ fatherName + ", itemName=" + itemName + ", size=" + size
				+ ", quantity=" + quantity + ", site=" + site + ", mobile="
				+ mobile + "]";
	}

}
