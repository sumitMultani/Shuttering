package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ItemStatusDto;
import com.example.demo.entity.Item;
import com.example.demo.entity.ItemStatus;
import com.example.demo.service.ItemService;
import com.example.demo.utils.Constants;

@RequestMapping("/stockItem")
@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = Constants.TOTAL_ITEM_LIST,  method = RequestMethod.GET)
	public Set<ItemDto> getStockItemList() {
		return itemService.getTotalStockItems();
	}
	
	@RequestMapping(value = Constants.STOCK_STATUS_ITEM_LIST,  method = RequestMethod.GET)
	public List<ItemStatusDto> getStockItems() {
		return itemService.getStockStatusItems();
	}
	
	@RequestMapping(value = Constants.ITEM_ID,  method = RequestMethod.GET)
	public ItemDto getItemById(@PathVariable Long itemId) {
		return itemService.getItemById(itemId);
	}
	
	@RequestMapping(value = Constants.ITEM_ID,  method = RequestMethod.DELETE)
	public void deleteItemById(@PathVariable Long  itemId) {
		 itemService.deleteItemById(itemId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public List<Item> saveItem(@RequestBody List<ItemDto> ItemDtos) {
		return itemService.addItem(ItemDtos);
	}
	
	@RequestMapping(value = Constants.ITEM_ID, method = RequestMethod.PUT)
	public ItemStatus updateItem(@RequestBody ItemStatusDto ItemDto, @PathVariable Long itemId) {
		return itemService.updateItem(ItemDto, itemId, null, null);
	}
	//item_received
	@RequestMapping(value = Constants.ADD_TEMP_ITEM, method = RequestMethod.POST)
	public ItemStatus addTempItem(@RequestBody ItemStatusDto ItemDto) {
		return itemService.addTempItem(ItemDto);
	}
	
	@RequestMapping(value = Constants.ITEM_NAMES,  method = RequestMethod.GET)
	public Set<String> getItemNames() {
		return itemService.getNames();
	}
	
	@RequestMapping(value = Constants.ITEM_SIZES,  method = RequestMethod.GET)
	public List<String> getItemSizes(@PathVariable String itemName) {
		return itemService.getSizes(itemName);
	}
	
	@RequestMapping(value = Constants.EXCESS_QUANTITY,  method = RequestMethod.GET)
	public Integer getItemExcessQuantity(@PathVariable String itemName) {
		return itemService.getQuantity(itemName);
	}
	
	@RequestMapping(value = Constants.ITEM_NAME,  method = RequestMethod.GET)
	public List<ItemDto>  getItemsByName(@PathVariable String itemName) {
		return itemService.getItemsByName(itemName);
	}
}
