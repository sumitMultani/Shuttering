package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PendencyReportDto;
import com.example.demo.service.PendencyService;

@RequestMapping("/pendency")
@RestController
public class PendencyController {
	
	@Autowired
	private PendencyService pendencyService;
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public List<PendencyReportDto> getIssuedItems(@RequestParam(required = false) String partyName, @RequestParam(required = false) String fatherName, 
			@RequestParam(required = false) String itemName, @RequestParam(required = false) String size, @RequestParam(required = false) String site) {
		return pendencyService.getPendencyReport(partyName, fatherName, itemName, size, site);
	}
	
}
