package com.example.demo.converter;

import com.example.demo.dto.ItemIssuedDto;
import com.example.demo.entity.ItemIssued;

/**
 * Created by sumit.
 */
public class ItemIssuedConverter {
	public static ItemIssued dtoToEntity(ItemIssuedDto itemIssuedDto) {
		ItemIssued itemIssued = new ItemIssued(itemIssuedDto.getIssueId(), itemIssuedDto.getIssuedDate(), itemIssuedDto.getTransactionType(), 
				itemIssuedDto.getChallanNo(), itemIssuedDto.getPartyName(), itemIssuedDto.getFatherName(), itemIssuedDto.getItemName(), itemIssuedDto.getSize(), itemIssuedDto.getQuantity(), 
				itemIssuedDto.getExcessQuantity(), itemIssuedDto.getBreakage(), itemIssuedDto.getShortage(), itemIssuedDto.getSize());
		return itemIssued;
	}

	public static ItemIssuedDto entityToDto(ItemIssued itemIssued) {
		ItemIssuedDto itemIssuedDto = new ItemIssuedDto(itemIssued.getIssueId(), itemIssued.getIssuedDate(), itemIssued.getTransactionType(), 
				itemIssued.getChallanNo(), itemIssued.getPartyName(), itemIssued.getFatherName(), itemIssued.getItemName(), itemIssued.getSize(), itemIssued.getQuantity(), 
				itemIssued.getExcessQuantity(), itemIssued.getBreakage(), itemIssued.getShortage(), itemIssued.getSquareFeet());
		return itemIssuedDto;
	}
}
