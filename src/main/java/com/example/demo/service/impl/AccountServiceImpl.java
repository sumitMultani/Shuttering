package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.AccountCoverter;
import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepositry;
import com.example.demo.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepositry accountRepositry;
	
	@Override
	public Account saveAccount(AccountDto accountDto) {
		return  accountRepositry.save(AccountCoverter.dtoToEntity(accountDto));
	}

	@Override
	public List<AccountDto> getAccounts() {
		return accountRepositry.findAll().stream()
				.map(AccountCoverter::entityToDto).collect(Collectors.toList());
	}

	@Override
	public List<String> getAccountNames() {
		List<String> names = new ArrayList<String>();
		List<AccountDto> accounts = accountRepositry.findAll().stream()
		.map(AccountCoverter::entityToDto).collect(Collectors.toList());
		if(accounts != null && !accounts.isEmpty()){
			for(AccountDto accountDto : accounts){
				names.add(accountDto.getAccountName());
			}
		}
		return names;
	}

	@Override
	public List<String> getAccountFatherNames(String partyName) {
		List<String> names = new ArrayList<String>();
		List<AccountDto> accounts = accountRepositry.findAll().stream()
		.map(AccountCoverter::entityToDto).collect(Collectors.toList());
		if(accounts != null && !accounts.isEmpty()){
			for(AccountDto accountDto : accounts){
				if(accountDto.getAccountName().equalsIgnoreCase(partyName))
					names.add(accountDto.getAccountFatherName());
			}
		}
		return names;
	}

}
