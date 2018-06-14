package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/items")
	public String items() {
		return "items";
	}
	
	@RequestMapping("/header")
	public String header() {
		return "header";
	}
	
	@RequestMapping("/itemList")
	public String itemList() {
		return "itemList";
	}
	
	@RequestMapping("/temp")
	public String temp() {
		return "temp";
	}
	
	@RequestMapping("/issued")
	public String issued() {
		return "issued";
	}
	
	@RequestMapping("/received")
	public String received() {
		return "received";
	}
	
	@RequestMapping("/receivedRegister")
	public String receivedRegister() {
		return "receivedRegister";
	}
	
	@RequestMapping("/issuedRegister")
	public String issuedRegister() {
		return "issuedRegister";
	}
	
	@RequestMapping("/stockStatus")
	public String stockStatus() {
		return "stockStatus";
	}
	
	@RequestMapping("/createAccount")
	public String createAccount() {
		return "createAccount";
	}
	
	@RequestMapping("/customerAccountList")
	public String customerAccountList() {
		return "customerAccountList";
	}
	
	@RequestMapping("/specificItem")
	public String specificItem() {
		return "specificItem";
	}

	@RequestMapping("/agreement")
	public String agreement() {
		return "agreement";
	}
	
	@RequestMapping("/createSite")
	public String createSite() {
		return "createSite";
	}
	@RequestMapping("/partyWiseDetails")
	public String partyWiseDetails() {
		return "partyWiseDetails";
	}
	@RequestMapping("/dailyTransaction")
	public String dailyTransaction() {
		return "dailyTransaction";
	}
	@RequestMapping("/pendencyReportRegister")
	public String pendencyReportRegister() {
		return "pendencyReportRegister";
	}
	
	
}
