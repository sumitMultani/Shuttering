package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = 3009610947013325046L;

	@Column(name = "account_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long accountId;

	@Column(name = "account_name")
	private String accountName;

	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "open_bal")
	private Integer openBal;

	@Column(name = "dr_cr")
	private String drCr;

	@Column(name = "group_name")
	private String group;

	@Column(name = "address")
	private String address;

	@Column(name = "address2")
	private String address2;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "phone")
	private Long phone;

	@Column(name = "mobile")
	private Long mobile;

	@Column(name = "service_tax_no")
	private String serviceTaxNo;

	@Column(name = "gst_no")
	private String gstNo;

	@Column(name = "email")
	private String email;

	@Column(name = "guranteer_name")
	private String guranteerName;

	@Column(name = "guranteer_Phn")
	private Long guranteerPhn;

	public Account() {
		// 0 - param constructor.
	}

	public Account(Long accountId, String accountName, String fatherName, Integer openBal,
			String drCr, String group, String address, String address2,
			String city, String state, Long phone, Long mobile,
			String serviceTaxNo, String gSTNo, String email,
			String guranteerName, Long guranteerPhn) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.fatherName = fatherName;
		this.openBal = openBal;
		this.drCr = drCr;
		this.group = group;
		this.address = address;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.mobile = mobile;
		this.serviceTaxNo = serviceTaxNo;
		this.gstNo = gSTNo;
		this.email = email;
		this.guranteerName = guranteerName;
		this.guranteerPhn = guranteerPhn;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Integer getOpenBal() {
		return openBal;
	}

	public void setOpenBal(Integer openBal) {
		this.openBal = openBal;
	}

	public String getDrCr() {
		return drCr;
	}

	public void setDrCr(String drCr) {
		this.drCr = drCr;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getServiceTaxNo() {
		return serviceTaxNo;
	}

	public void setServiceTaxNo(String serviceTaxNo) {
		this.serviceTaxNo = serviceTaxNo;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGuranteerName() {
		return guranteerName;
	}

	public void setGuranteerName(String guranteerName) {
		this.guranteerName = guranteerName;
	}

	public Long getGuranteerPhn() {
		return guranteerPhn;
	}

	public void setGuranteerPhn(Long guranteerPhn) {
		this.guranteerPhn = guranteerPhn;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName="
				+ accountName + ", openBal=" + openBal + ", drCr=" + drCr
				+ ", group=" + group + ", address1=" + address + ", address2="
				+ address2 + ", city=" + city + ", state=" + state + ", phone="
				+ phone + ", mobile=" + mobile + ", serviceTaxNo="
				+ serviceTaxNo + ", GSTNo=" + gstNo + ", email=" + email
				+ ", guranteerName=" + guranteerName + ", guranteerPhn="
				+ guranteerPhn + "]";
	}

}
