package com.example.demo.converter;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;

public class AccountCoverter {

	public static Account dtoToEntity(AccountDto accountDto) {
		Account account = new Account(accountDto.getAccountId(), accountDto.getAccountName(), accountDto.getAccountFatherName(), accountDto.getOpenBal(),
				accountDto.getDrCr(), accountDto.getGroup(), accountDto.getAddress(), accountDto.getAddress2(),
				accountDto.getCity(), accountDto.getState(), accountDto.getPhone(), accountDto.getMobile(),
				accountDto.getServiceTaxNo(), accountDto.getGstNo(), accountDto.getEmail(),
				accountDto.getGuranteerName(), accountDto.getGuranteerPhn());
		return account;
	}
	
	public static AccountDto entityToDto(Account account) {
		AccountDto accountDto = new AccountDto(account.getAccountId(), account.getAccountName(), account.getFatherName(), account.getOpenBal(),
				account.getDrCr(), account.getGroup(), account.getAddress(), account.getAddress2(),
				account.getCity(), account.getState(), account.getPhone(), account.getMobile(),
				account.getServiceTaxNo(), account.getGstNo(), account.getEmail(),
				account.getGuranteerName(), account.getGuranteerPhn());
		return accountDto;
	}
}
