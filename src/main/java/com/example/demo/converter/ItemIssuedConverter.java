package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ItemIssuedDto;
import com.example.demo.entity.ItemIssued;

/**
 * Created by sumit.
 */
@Component
public class ItemIssuedConverter {
	public  ItemIssued dtoToEntity(ItemIssuedDto itemIssuedDto) {
		ItemIssued itemIssued = new ItemIssued(itemIssuedDto.getIssueId(), itemIssuedDto.getIssuedDate(), itemIssuedDto.getTransactionType(), 
				itemIssuedDto.getChallanNo(), itemIssuedDto.getPartyName(), itemIssuedDto.getFatherName(), itemIssuedDto.getItemName(), itemIssuedDto.getSize(), itemIssuedDto.getQuantity(), 
				itemIssuedDto.getExcessQuantity() , itemIssuedDto.getSize(), itemIssuedDto.getSite(), itemIssuedDto.getMobile());
		return itemIssued;
	}

	public  ItemIssuedDto entityToDto(ItemIssued itemIssued) {
		ItemIssuedDto itemIssuedDto = new ItemIssuedDto(itemIssued.getIssueId(), itemIssued.getIssuedDate(), itemIssued.getTransactionType(), 
				itemIssued.getChallanNo(), itemIssued.getPartyName(), itemIssued.getFatherName(), itemIssued.getItemName(), itemIssued.getSize(), itemIssued.getQuantity(), 
				itemIssued.getExcessQuantity() , itemIssued.getSquareFeet(),  itemIssued.getSite(),  itemIssued.getMobile());
		return itemIssuedDto;
	}
}
