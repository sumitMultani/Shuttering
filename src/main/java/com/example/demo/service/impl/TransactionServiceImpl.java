package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.ItemIssuedConverter;
import com.example.demo.converter.ItemReceivedConverter;
import com.example.demo.dto.ItemIssuedDto;
import com.example.demo.dto.ItemReceivedDto;
import com.example.demo.dto.TransactionDto;
import com.example.demo.entity.ItemIssued;
import com.example.demo.entity.ItemReceived;
import com.example.demo.repository.IssuedRepository;
import com.example.demo.repository.ReceivedRepository;
import com.example.demo.service.TransactionService;
import com.example.demo.utils.Util;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private IssuedRepository issuedRepository;
	
	@Autowired
	private ReceivedRepository receivedRepository;
	
	@Autowired
	private ItemIssuedConverter itemIssuedConverter;
	
	@Autowired
	private ItemReceivedConverter itemReceivedConverter;
	
	@Autowired
	private Util util;
	
	@Override
	public List<TransactionDto> getTransactions(String startDate, String endDate, String itemName, String partyName, String fatherName) {
		 
		startDate = util.dateConverter(startDate);
		endDate = util.dateConverter(endDate);
		
		List<TransactionDto> transactions = new ArrayList<TransactionDto>();
		
		 if(startDate != null && endDate != null) {
			 List<ItemIssued> itemIssueds = null;
			 if(itemName == null && partyName == null && fatherName == null)
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqual(startDate, endDate);
			 else if(itemName != null && partyName == null && fatherName == null)
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndItemName(startDate, endDate, itemName);
			 else if(itemName != null && partyName != null && fatherName == null)
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndItemNameAndPartyName(startDate, endDate, itemName, partyName);
			 else if(itemName != null && partyName != null && fatherName != null)
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndItemNameAndPartyNameAndFatherName(startDate, endDate, itemName, partyName, fatherName);
			 else if(itemName == null && partyName != null && fatherName == null)
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndPartyName(startDate, endDate, partyName);
			 else if(itemName == null && partyName != null && fatherName != null)
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndPartyNameAndFatherName(startDate, endDate, partyName, fatherName);
			 
			 itemIssueds.forEach(itemIssued ->{
				 TransactionDto transactionDto = new TransactionDto();
				 ItemIssuedDto itemIssuedDto = itemIssuedConverter.entityToDto(itemIssued);
				 transactionDto.setDate(itemIssuedDto.getIssuedDate());
				 transactionDto.setTransactionType(itemIssuedDto.getTransactionType());
				 transactionDto.setPartyName(itemIssuedDto.getPartyName());
				 transactionDto.setFatherName(itemIssuedDto.getFatherName());
				 transactionDto.setItemName(itemIssued.getItemName());
				 transactionDto.setSize(itemIssued.getSize());
				 transactionDto.setQuantity(itemIssued.getQuantity());
				 transactionDto.setSite(itemIssued.getSite());
				 transactionDto.setMobile(itemIssued.getMobile());
				 transactions.add(transactionDto);
			 });
			 
			 List<ItemReceived> itemReceiveds = receivedRepository.findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqual(startDate, endDate);
			 itemReceiveds.forEach(itemReceived ->{
			     TransactionDto transactionDto = new TransactionDto();
				 ItemReceivedDto itemReceivedDto = itemReceivedConverter.entityToDto(itemReceived);
				 transactionDto.setDate(itemReceivedDto.getReceivedDate());
			     transactionDto.setTransactionType(itemReceivedDto.getTransactionType());
				 transactionDto.setPartyName(itemReceivedDto.getPartyName());
				 transactionDto.setFatherName(itemReceivedDto.getFatherName());
				 transactionDto.setItemName(itemReceivedDto.getItemName());
				 transactionDto.setSize(itemReceivedDto.getSize());
				 transactionDto.setQuantity(itemReceivedDto.getQuantity());
   				 transactionDto.setBreakage(itemReceivedDto.getBreakage());
				 transactionDto.setShortage(itemReceivedDto.getShortage());
				 transactionDto.setSite(itemReceivedDto.getSite());
				 transactionDto.setMobile(itemReceivedDto.getMobile());
				 transactions.add(transactionDto);
			 });
			 
			  
		 }
		 return transactions;
	}

	 

}
