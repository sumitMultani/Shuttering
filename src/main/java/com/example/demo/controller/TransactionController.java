package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TransactionDto;
import com.example.demo.service.TransactionService;

@RequestMapping("/transaction")
@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value = "/{startDate}/{endDate}" ,method = RequestMethod.GET)
	public List<TransactionDto> getTransactions(@PathVariable String startDate, @PathVariable String endDate,
			@RequestParam(required = false) String itemName, @RequestParam(required = false) String partyName,
			@RequestParam(required = false) String fatherName) {
		return transactionService.getTransactions(startDate, endDate, itemName, partyName, fatherName);
	}
}
