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
	public List<TransactionDto> getTransactions(String startDate, String endDate, String itemName, String partyName, String fatherName, String size, String site) {
		 
	
		if(itemName != null && (itemName.equalsIgnoreCase("null") || itemName.trim().equalsIgnoreCase("")))
			itemName = null;
		if(partyName != null && (partyName.equalsIgnoreCase("null") || partyName.trim().equalsIgnoreCase("")))
			partyName = null;
		if(fatherName != null && (fatherName.equalsIgnoreCase("null") || fatherName.trim().equalsIgnoreCase("")))
			fatherName = null;
		if(size != null && (size.equalsIgnoreCase("null") || size.trim().equalsIgnoreCase("")))
			size = null;
		if(site != null && (site.equalsIgnoreCase("null") || site.trim().equalsIgnoreCase("")))
			site = null;
		
		
		
		List<TransactionDto> transactions = new ArrayList<TransactionDto>();
		if(startDate != null && endDate != null) {
			 startDate = util.dateConverter(startDate);
			 endDate = util.dateConverter(endDate);
				
			 List<ItemIssued> itemIssueds = null;
			 List<ItemReceived> itemReceiveds = null;
			 
			 if(itemName == null && partyName == null && fatherName == null && size == null && site == null) {
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqual(startDate, endDate);
				 itemReceiveds = receivedRepository.findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqual(startDate, endDate);
			 }
			 else if(itemName != null && partyName == null && fatherName == null && size == null && site == null) {
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndItemName(startDate, endDate, itemName);
				 itemReceiveds = receivedRepository.findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndItemName(startDate, endDate, itemName);
			 }
			 else if(itemName != null && partyName != null && fatherName == null && size == null && site == null) {
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndItemNameAndPartyName(startDate, endDate, itemName, partyName);
				 itemReceiveds = receivedRepository.findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndItemNameAndPartyName(startDate, endDate, itemName, partyName);
			 }
			 else if(itemName != null && partyName != null && fatherName != null && size == null && site == null) {
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndItemNameAndPartyNameAndFatherName(startDate, endDate, itemName, partyName, fatherName);
				 itemReceiveds = receivedRepository.findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndItemNameAndPartyNameAndFatherName(startDate, endDate, itemName, partyName, fatherName);
			 }
			 else if(itemName == null && partyName != null && fatherName == null && size == null && site == null) {
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndPartyName(startDate, endDate, partyName);
				 itemReceiveds = receivedRepository.findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndPartyName(startDate, endDate, partyName);
			 }
			 else if(itemName == null && partyName != null && fatherName != null && size == null && site == null) {
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndPartyNameAndFatherName(startDate, endDate, partyName, fatherName);
				 itemReceiveds = receivedRepository.findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndPartyNameAndFatherName(startDate, endDate, partyName, fatherName);
			 }
			 
			 else if(itemName != null && partyName != null && fatherName != null && size != null && site == null) {
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndItemNameAndPartyNameAndFatherNameAndSize(startDate, endDate, itemName, partyName, fatherName, size);
				 itemReceiveds = receivedRepository.findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndItemNameAndPartyNameAndFatherNameAndSize(startDate, endDate, itemName, partyName, fatherName, size);
			 }
			 
			 else if(itemName != null && partyName != null && fatherName != null && size != null && site != null) {
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndItemNameAndPartyNameAndFatherNameAndSizeAndSite(startDate, endDate, itemName, partyName, fatherName, size, site);
				 itemReceiveds = receivedRepository.findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndItemNameAndPartyNameAndFatherNameAndSizeAndSite(startDate, endDate, itemName, partyName, fatherName, size, site);
			 }
			 else if(itemName == null && partyName == null && fatherName == null && size == null && site != null) {
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndSite(startDate, endDate, site);
				 itemReceiveds = receivedRepository.findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndSite(startDate, endDate, site);
			 }
			 
			 else if(itemName != null && partyName == null && fatherName == null && size == null && site != null) {
				 itemIssueds = issuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndItemNameAndSite(startDate, endDate, itemName, site);
				 itemReceiveds = receivedRepository.findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndItemNameAndSite(startDate, endDate,itemName, site);
			 }
			 
			 itemIssueds.forEach(itemIssued ->{
				 TransactionDto transactionDto = new TransactionDto();
				 ItemIssuedDto itemIssuedDto = itemIssuedConverter.entityToDto(itemIssued);
				 transactionDto.setDate(itemIssuedDto.getIssuedDate());
				 transactionDto.setVoucher("V_I_123");
				 transactionDto.setPartyName(itemIssuedDto.getPartyName());
				 transactionDto.setFatherName(itemIssuedDto.getFatherName());
				 transactionDto.setItemName(itemIssued.getItemName());
				 transactionDto.setSize(itemIssued.getSize());
				 transactionDto.setQuantity(itemIssued.getQuantity());
				 transactionDto.setTransactionType(itemIssuedDto.getTransactionType());
				 transactionDto.setBreakage(0);
				 transactionDto.setShortage(0);
				 transactionDto.setSite(itemIssued.getSite());
				 transactionDto.setRemarks(itemIssued.getRemarks());
				 transactions.add(transactionDto);
			 });
			 
			  
			 itemReceiveds.forEach(itemReceived ->{
			     TransactionDto transactionDto = new TransactionDto();
				 ItemReceivedDto itemReceivedDto = itemReceivedConverter.entityToDto(itemReceived);
				 transactionDto.setDate(itemReceivedDto.getReceivedDate());
				 transactionDto.setVoucher("V_R_123");
				 transactionDto.setPartyName(itemReceivedDto.getPartyName());
				 transactionDto.setFatherName(itemReceivedDto.getFatherName());
				 transactionDto.setItemName(itemReceivedDto.getItemName());
				 transactionDto.setSize(itemReceivedDto.getSize());
				 transactionDto.setQuantity(itemReceivedDto.getQuantity());
			     transactionDto.setTransactionType(itemReceivedDto.getTransactionType());
   				 transactionDto.setBreakage(itemReceivedDto.getBreakage());
				 transactionDto.setShortage(itemReceivedDto.getShortage());
				 transactionDto.setSite(itemReceivedDto.getSite());
				 transactionDto.setRemarks("-");
				 transactions.add(transactionDto);
			 });
			 
			  
		 }
		 return transactions;
	}

	 

}
