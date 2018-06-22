package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ItemIssuedDto;
import com.example.demo.entity.ItemIssued;
import com.example.demo.service.IssuedService;

@RequestMapping("/issued")
@RestController
public class IssuedController {

	@Autowired
	private IssuedService issuedService;
	
	@RequestMapping(method = RequestMethod.POST)
	public List<ItemIssued> saveItem(@RequestBody List<ItemIssuedDto> ItemIssuedDtos) {
		return issuedService.saveItem(ItemIssuedDtos);
	}
	

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public List<ItemIssued> getIssuedItem() {
		return issuedService.getIssuedRegister();
	}
	
	@RequestMapping(value = "/filter/{startDate}/{endDate}", method = RequestMethod.GET )
	public List<ItemIssuedDto> getIssuedFilterByDate(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {
		return issuedService.getIssuedFilterByDate(startDate, endDate);
	}
	
	@RequestMapping(value = "/partynames", method = RequestMethod.GET)
	public List<String> getPartyNames() {
		return issuedService.getPartyNames();
	}
	
	@RequestMapping(value = "/fathernames", method = RequestMethod.GET)
	public List<String> getFatherNames(String partyName) {
		return issuedService.getFatherNames(partyName);
	}
	
	@RequestMapping(value = "/sites", method = RequestMethod.GET)
	public List<String> getSites(String partyName, String fatherName) {
		return issuedService.getSites(partyName, fatherName);
	}
	
}
