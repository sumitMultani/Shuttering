package com.example.demo.converter;

import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ItemStatusDto;
import com.example.demo.entity.Item;
import com.example.demo.entity.ItemStatus;

/**
 * Created by sumit.
 */
public class ItemConverter {
	public static ItemStatus dtoToItemStatusEntity(ItemStatusDto itemStatusDto) {
		ItemStatus item = new ItemStatus(itemStatusDto.getItemId(), itemStatusDto.getItemName(), itemStatusDto.getLength(),
				itemStatusDto.getWidth(), itemStatusDto.getSize(), itemStatusDto.getRate(), itemStatusDto.getPer(),
				itemStatusDto.getStock(), itemStatusDto.getRentPerDay(), itemStatusDto.getReceived(),
				itemStatusDto.getIssued(), itemStatusDto.getPurchased(), itemStatusDto.getShortage(),
				itemStatusDto.getBreakage());
		return item;
	}

	public static ItemStatusDto itemStatusEntityToDto(ItemStatus itemStatus) {
		ItemStatusDto itemDto = new ItemStatusDto(itemStatus.getItemId(), itemStatus.getItemName(), itemStatus.getLength(),
				itemStatus.getWidth(), itemStatus.getSize(), itemStatus.getRate(), itemStatus.getPer(),
				itemStatus.getStock(), itemStatus.getRentPerDay(), itemStatus.getReceived(),
				itemStatus.getIssued(), itemStatus.getPurchased(), itemStatus.getShortage(),
				itemStatus.getBreakage());
		return itemDto;
	}
	
	public static Item dtoToItemEntity(ItemDto itemDto) {
		Item item = new Item(itemDto.getItemId(), itemDto.getItemName(), itemDto.getLength(), itemDto.getWidth(),
				itemDto.getSquareFeet(), itemDto.getSize(), itemDto.getRate(), itemDto.getPer(),
				itemDto.getStock(), itemDto.getRentPerDay(), itemDto.getBreakageCharges());
		return item;
	}

	public static ItemDto itemEntityToDto(Item item) {
		ItemDto itemDto = new ItemDto(item.getItemId(), item.getItemName(), item.getLength(), item.getWidth(),
				item.getSquareFeet(), item.getSize(), item.getRate(), item.getPer(),
				item.getStock(), item.getRentPerDay(), item.getBreakageCharges());
		return itemDto;
	}
}
