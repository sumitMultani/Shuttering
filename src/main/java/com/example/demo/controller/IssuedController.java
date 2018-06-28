package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<ItemIssued> getIssuedItem(@RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate, 
			@RequestParam(required = false) String partyName, @RequestParam(required = false) String fatherName, @RequestParam(required = false) String itemName ) {
		return issuedService.getIssuedRegister(startDate, endDate, partyName, fatherName, itemName);
	}
	
	@RequestMapping(value = "/filter/{startDate}/{endDate}", method = RequestMethod.GET )
	public List<ItemIssuedDto> getIssuedFilterByDate(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {
		return issuedService.getIssuedFilterByDate(startDate, endDate);
	}
	
	@RequestMapping(value = "/partynames", method = RequestMethod.GET)
	public List<String> getPartyNames() {
		return issuedService.getPartyNames();
	}
	
	@RequestMapping(value = "/fathernames/{partyName}", method = RequestMethod.GET)
	public List<String> getFatherNames(@PathVariable String partyName) {
		return issuedService.getFatherNames(partyName);
	}
	
	@RequestMapping(value = "/sites/{partyname}/{fathername}", method = RequestMethod.GET)
	public List<String> getSites(@PathVariable String partyname,@PathVariable String fathername) {
		return issuedService.getSites(partyname, fathername);
	}
	
	@RequestMapping(value = "/itemnames", method = RequestMethod.GET)
	public List<String> getItemNames() {
		return issuedService.getItemNames();
	}
	
	@RequestMapping(value = "/itemsize/{itemname}", method = RequestMethod.GET)
	public List<String> getItemSize(@PathVariable String itemname) {
		return issuedService.getItemSize(itemname);
	}
	
}
