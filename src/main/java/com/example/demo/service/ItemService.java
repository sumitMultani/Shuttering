package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.entity.ItemStatus;

/**
 * Created by sumit
 */
public interface ItemService {
    ItemDto getItemById(Long itemId);
    void deleteItemById(Long itemId);
    List<ItemDto> getStockStatusItems();
	List<Item> addItem(List<ItemDto> itemDto);
	ItemStatus updateItem(ItemDto itemDto, Long itemId, Integer receivedQuantity, Integer issuedQuantity);
	ItemStatus addTempItem(ItemDto itemDto);
	List<String> getNames();
	List<String> getSizes();
	Integer getQuantity(String itemName);
	Set<ItemDto> getTotalStockItems();
	List<ItemDto> getItemsByName(String itemName);
	 
}
