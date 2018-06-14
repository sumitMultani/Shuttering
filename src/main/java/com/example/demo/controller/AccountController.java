package com.example.demo.controller;
//stock_items
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

@RequestMapping("/account")
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Account saveAccount(@RequestBody AccountDto accountDto) {
		return accountService.saveAccount(accountDto);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<AccountDto> getAccounts() {
		return accountService.getAccounts();
	}
	
	@RequestMapping(value = "/names",method = RequestMethod.GET)
	public List<String> getAccountNames() {
		return accountService.getAccountNames();
	}
	
	@RequestMapping(value = "/fathernames",method = RequestMethod.GET)
	public List<String> getAccountFatherNames() {
		return accountService.getAccountFatherNames();
	}
	
	 
}
