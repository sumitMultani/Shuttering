package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;

/**
 * Created by sumit
 */
public interface AccountService {

	Account saveAccount(AccountDto accountDto);

	List<AccountDto> getAccounts();

	List<String> getAccountNames();

	List<String> getAccountFatherNames();

    
}
