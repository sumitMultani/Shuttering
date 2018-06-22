package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IssuedService;

@RequestMapping("/availstock")
@RestController
public class AvialableBalController {

	@Autowired
	private IssuedService issuedService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Integer> getAvailStock(@RequestParam(required = false) String partyName, @RequestParam(required = false) String fatherName,
			@RequestParam(required = false) String itemName, @RequestParam(required = false) String size, @RequestParam(required = false) String site) {
		return issuedService.getAvailStock(partyName, fatherName, itemName, size, site);
	}
	
}
