package com.example.demo.converter;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.entity.ItemStatus;

/**
 * Created by sumit.
 */
public class ItemConverter {
	public static ItemStatus dtoToItemStatusEntity(ItemDto itemDto) {
		ItemStatus item = new ItemStatus(itemDto.getItemId(), itemDto.getItemName(), itemDto.getLength(), itemDto.getWidth(), 
				itemDto.getSize(), itemDto.getRate(),itemDto.getPer(), itemDto.getStock(), itemDto.getRentPerDay(), itemDto.getBrokerCharges(),
				itemDto.getReceived(), itemDto.getIssued(), itemDto.getPurchased(), itemDto.getShortage(), itemDto.getBreakage());
		return item;
	}

	public static ItemDto itemStatusEntityToDto(ItemStatus item) {
		ItemDto itemDto = new ItemDto(item.getItemId(), item.getItemName(), item.getLength(), item.getWidth(), 
				item.getSize(), item.getRate(),item.getPer(), item.getStock(), item.getRentPerDay(), 0 ,
				item.getReceived(), item.getIssued(), item.getPurchased(), item.getShortage(), item.getBreakage());
		return itemDto;
	}
	
//	Long itemId, String itemName, Integer length, Integer width,
//	String squareFeet, Integer rate, String per, Integer stock,
//	Integer rentPerDay, Integer brokerCharges, Integer received,
//	Integer issued, Integer purchaed, Integer shortage, Integer breakage
	
	public static Item dtoToItemEntity(ItemDto itemDto) {
		Item item = new Item(itemDto.getItemId(), itemDto.getItemName(), itemDto.getLength(), itemDto.getWidth(), itemDto.getSquareFeet(), itemDto.getRate(),
				itemDto.getPer(), itemDto.getStock(), itemDto.getRentPerDay(),
				itemDto.getBrokerCharges(), itemDto.getReceived(), itemDto.getIssued(), itemDto.getPurchased(), itemDto.getShortage(), itemDto.getBreakage());
		return item;
	}

	public static ItemDto itemEntityToDto(Item item) {
		ItemDto itemDto = new ItemDto(item.getItemId(), item.getItemName(), item.getLength(), item.getWidth(), item.getSquareFeet(), item.getRate(),
				item.getPer(), item.getStock(), item.getRentPerDay(), item.getBrokerCharges(), item.getReceived(), item.getIssued(), item.getPurchaed(), 
				item.getShortage(), item.getBreakage());
		return itemDto;
	}
}
