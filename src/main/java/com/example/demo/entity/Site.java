package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Site.
 */
@Entity
@Table(name = "site")
public class Site implements Serializable {

	private static final long serialVersionUID = 9040350897479194195L;

	@Column(name = "site_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long siteId;

	@Column(name = "site_name")
	private String siteName;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "supervisior_name")
	private String supervisiorName;

	@Column(name = "supervisiorPhone")
	private Long supervisiorPhone;

	/**
	 * Gets the site id.
	 *
	 * @return the site id
	 */
	public Long getSiteId() {
		return siteId;
	}

	/**
	 * Sets the site id.
	 *
	 * @param siteId
	 *            the new site id
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	/**
	 * Gets the site name.
	 *
	 * @return the site name
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * Sets the site name.
	 *
	 * @param siteName
	 *            the new site name
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address
	 *            the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city
	 *            the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the supervisior name.
	 *
	 * @return the supervisior name
	 */
	public String getSupervisiorName() {
		return supervisiorName;
	}

	/**
	 * Sets the supervisior name.
	 *
	 * @param supervisiorName
	 *            the new supervisior name
	 */
	public void setSupervisiorName(String supervisiorName) {
		this.supervisiorName = supervisiorName;
	}

	/**
	 * Gets the supervisior phone.
	 *
	 * @return the supervisior phone
	 */
	public Long getSupervisiorPhone() {
		return supervisiorPhone;
	}

	/**
	 * Sets the supervisior phone.
	 *
	 * @param supervisiorPhone
	 *            the new supervisior phone
	 */
	public void setSupervisiorPhone(Long supervisiorPhone) {
		this.supervisiorPhone = supervisiorPhone;
	}

	public Site(Long siteId, String siteName, String address, String city,
			String supervisiorName, Long supervisiorPhone) {
		this.siteId = siteId;
		this.siteName = siteName;
		this.address = address;
		this.city = city;
		this.supervisiorName = supervisiorName;
		this.supervisiorPhone = supervisiorPhone;
	}

	public Site() {
	}

	@Override
	public String toString() {
		return "Site [siteId=" + siteId + ", siteName=" + siteName
				+ ", address=" + address + ", city=" + city
				+ ", supervisiorName=" + supervisiorName
				+ ", supervisiorPhone=" + supervisiorPhone + "]";
	}

}
