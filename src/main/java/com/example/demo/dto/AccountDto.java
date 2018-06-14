package com.example.demo.dto;

import java.io.Serializable;

public class AccountDto implements Serializable {

	private static final long serialVersionUID = 4700471579919904387L;

	private Long accountId;
	private String accountName;
	private String accountFatherName;
	private Integer openBal;
	private String drCr;
	private String group;
	private String address;
	private String address2;
	private String city;
	private String state;
	private Long phone;
	private Long mobile;
	private String serviceTaxNo;
	private String gstNo;
	private String email;
	private String guranteerName;
	private Long guranteerPhn;

	public AccountDto() {
		// 0 - param constructor.
	}

	public AccountDto(Long accountId, String accountName,
			String accountFatherName, Integer openBal, String drCr,
			String group, String address, String address2, String city,
			String state, Long phone, Long mobile, String serviceTaxNo,
			String gSTNo, String email, String guranteerName, Long guranteerPhn) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountFatherName = accountFatherName;
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

	public String getAccountFatherName() {
		return accountFatherName;
	}

	public void setAccountFatherName(String accountFatherName) {
		this.accountFatherName = accountFatherName;
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
		return "AccountDto [accountId=" + accountId + ", accountName="
				+ accountName + ", accountFatherName=" + accountFatherName
				+ ", openBal=" + openBal + ", drCr=" + drCr + ", group="
				+ group + ", address=" + address + ", address2=" + address2
				+ ", city=" + city + ", state=" + state + ", phone=" + phone
				+ ", mobile=" + mobile + ", serviceTaxNo=" + serviceTaxNo
				+ ", gstNo=" + gstNo + ", email=" + email + ", guranteerName="
				+ guranteerName + ", guranteerPhn=" + guranteerPhn + "]";
	}

}
