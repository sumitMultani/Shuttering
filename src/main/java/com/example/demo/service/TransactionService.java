package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TransactionDto;


public interface TransactionService {

	List<TransactionDto> getTransactions(String startDate, String endDate, String itemName, String partyName, String fatherName);


}
