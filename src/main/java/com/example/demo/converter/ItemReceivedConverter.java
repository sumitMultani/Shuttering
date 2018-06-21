package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ItemReceivedDto;
import com.example.demo.entity.ItemReceived;

/**
 * Created by sumit.
 */
@Component
public class ItemReceivedConverter {
	
	public   ItemReceived dtoToEntity(ItemReceivedDto itemIssuedDto) {
		ItemReceived itemIssued = new ItemReceived(itemIssuedDto.getReceivedId(), itemIssuedDto.getReceivedDate(), itemIssuedDto.getTransactionType(), 
				itemIssuedDto.getChallanNo(), itemIssuedDto.getPartyName(), itemIssuedDto.getFatherName(), itemIssuedDto.getItemName(), itemIssuedDto.getSize(), itemIssuedDto.getQuantity(), 
				itemIssuedDto.getExcessQuantity(), itemIssuedDto.getBreakage(), itemIssuedDto.getShortage(), itemIssuedDto.getSize(), itemIssuedDto.getSite(), itemIssuedDto.getMobile());
		return itemIssued;
	}

	public   ItemReceivedDto entityToDto(ItemReceived itemIssued) {
		ItemReceivedDto itemIssuedDto = new ItemReceivedDto(itemIssued.getReceivedId(), itemIssued.getReceivedDate(), itemIssued.getTransactionType(), 
				itemIssued.getChallanNo(), itemIssued.getPartyName(), itemIssued.getFatherName(), itemIssued.getItemName(), itemIssued.getSize(), itemIssued.getQuantity(), 
				itemIssued.getExcessQuantity(), itemIssued.getBreakage(), itemIssued.getShortage(), itemIssued.getSquareFeet(), itemIssued.getSite(), itemIssued.getMobile());
		return itemIssuedDto;
	}
}
