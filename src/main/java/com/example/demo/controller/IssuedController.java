package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
