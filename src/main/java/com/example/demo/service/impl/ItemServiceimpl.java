package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.ItemConverter;
import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ItemStatusDto;
import com.example.demo.entity.Item;
import com.example.demo.entity.ItemStatus;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.ItemStatusRepository;
import com.example.demo.repository.ItemStockStatusRepository;
import com.example.demo.service.ItemService;

/**
 * Created by sumit
 */
@Service
public class ItemServiceimpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemStatusRepository itemStatusRepository;

	@Autowired
	private ItemStockStatusRepository itemStockStatusRepository;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ItemService itemService;

	@Override
	public ItemDto getItemById(Long itemId) {
		return ItemConverter.itemEntityToDto(itemRepository.getOne(itemId));
	}

	@Override
	public void deleteItemById(Long itemId) {
		itemRepository.delete(itemId);
	}

	@Override
	public List<ItemStatusDto> getStockStatusItems() {
		return itemStatusRepository.findAll().stream()
				.map(ItemConverter::itemStatusEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public ItemStatus updateItem(ItemStatusDto itemStatusDto, Long itemId,
			Integer receivedQuantity, Integer issuedQuantity) {
		ItemStatus itemStatus = null;
		Transaction tx = null;
		try {
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			ItemStatusDto entityDto = ItemConverter
					.itemStatusEntityToDto(itemStockStatusRepository
							.getOne(itemId));
			if (entityDto != null)
				itemStatusDto.setItemId(entityDto.getItemId());
			if (issuedQuantity != null) {
				itemStatusDto.setIssued(issuedQuantity);
				if(entityDto != null && entityDto.getIssued() != null)
					itemStatusDto.setIssued(entityDto.getIssued() + issuedQuantity);
			}
			 
			if(receivedQuantity != null) {
			if(entityDto.getReceived() != null)
				itemStatusDto.setReceived(entityDto.getReceived() + receivedQuantity);
			else
				itemStatusDto.setReceived(0 + receivedQuantity);
		    }
			//if(entityDto.getIssued() != null ) {
			//	itemDto.setIssued(entityDto.getIssued());
			//	itemDto.setBrokerCharges(entityDto.getBrokerCharges());
			//}
			if(entityDto!= null) {
				if(itemStatusDto.getBreakage() != null)
					itemStatusDto.setStock(itemStatusDto.getStock() - itemStatusDto.getBreakage());
				if(itemStatusDto.getShortage() != null)
					itemStatusDto.setStock(itemStatusDto.getStock() - itemStatusDto.getShortage());
				
				Integer breakage = entityDto.getBreakage();
				Integer shortage = entityDto.getShortage();
				if(breakage != null  ){
					itemStatusDto.setBreakage(breakage + itemStatusDto.getBreakage());
				}else
					itemStatusDto.setBreakage(itemStatusDto.getBreakage());
				if(shortage != null){
					itemStatusDto.setShortage(shortage + itemStatusDto.getShortage());
				}else
					itemStatusDto.setShortage(itemStatusDto.getShortage());
				
				//itemDto.setStock(entityDto.getStock());
				
			}
			
			itemStatus = ItemConverter.dtoToItemStatusEntity(itemStatusDto);
			session.update(itemStatus);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return itemStatus;
	}

	@Override
	public List<Item> addItem(List<ItemDto> itemDtos) {
		List<Item> items = new ArrayList<Item>();
		List<ItemStatus> itemsStatus = new ArrayList<ItemStatus>();
		if (itemDtos != null && !itemDtos.isEmpty()) {
			for (ItemDto itemDto : itemDtos) {
				ItemStatusDto itemStatusDto = setItemStatusDto(itemDto);
				String size = "";
				if(itemDto.getLength() != null && itemDto.getWidth() != null)
					size = itemDto.getLength().toString()+"*"+itemDto.getWidth();
				if(itemDto.getLength() != null && (itemDto.getWidth() == null || itemDto.getWidth() == 0))
					size = itemDto.getLength()+"ft";
				itemDto.setSize(size);
				itemStatusDto.setSize(size);
				Item item = itemRepository.save(ItemConverter.dtoToItemEntity(itemDto));
				items.add(item);
				ItemStatus itemStatus = itemStatusRepository.save(ItemConverter.dtoToItemStatusEntity(itemStatusDto));
				itemsStatus.add(itemStatus);
			}
		}
		return items;
	}

	private ItemStatusDto setItemStatusDto(ItemDto itemDto) {
		ItemStatusDto itemStatusDto = new ItemStatusDto();
		itemStatusDto.setItemName(itemDto.getItemName());
		itemStatusDto.setLength(itemDto.getLength());
		itemStatusDto.setWidth(itemDto.getWidth());
		itemStatusDto.setSize(itemDto.getSize());
		itemStatusDto.setRate(itemDto.getRate());
		itemStatusDto.setPer(itemDto.getPer());
		itemStatusDto.setStock(itemDto.getStock());
		itemStatusDto.setRentPerDay(itemDto.getRentPerDay());
		return itemStatusDto;
	}

	// SAVE DATA INTO STOCK STATUS
	/*
	 * public List<ItemStatus> addItem(List<ItemDto> itemDtos) {
	 * List<ItemStatus> items = new ArrayList<ItemStatus>(); if(itemDtos != null
	 * && !itemDtos.isEmpty()){ for(ItemDto itemDto : itemDtos) { ItemStatus
	 * item = itemRepository.save(ItemConverter.dtoToEntity(itemDto));
	 * items.add(item); } } return items; }
	 */

	@Override
	public ItemStatus addTempItem(ItemStatusDto itemStatusDto) {
		ItemStatus item = ItemConverter.dtoToItemStatusEntity(itemStatusDto);
		return item;
	}

	@Override
	public Set<String> getNames() {
		Set<String> names = new HashSet<String>();
		List<ItemStatusDto> allItems = itemService.getStockStatusItems();
		if (allItems != null && !allItems.isEmpty()) {
			for (ItemStatusDto itemDto : allItems) {
				names.add(itemDto.getItemName());
			}
		}
		return names;
	}

	@Override
	public List<String> getSizes() {
		List<String> sizes = new ArrayList<String>();
		List<ItemStatusDto> allItems = itemService.getStockStatusItems();
		if (allItems != null && !allItems.isEmpty()) {
			for (ItemStatusDto itemDto : allItems) {
				sizes.add(itemDto.getSize());
			}
		}
		return sizes;
	}

	@Override
	public Integer getQuantity(String itemName) {
		Item item = null;
		Session session = sessionFactory.openSession();
		Criteria itemCriteria = session.createCriteria(Item.class);
		itemCriteria.add(Restrictions.eq("itemName", itemName));
		List<?> list = itemCriteria.list();
		if (list != null && !list.isEmpty())
			item = (Item) list.get(0);
		return item.getStock();
	}

	@Override
	public Set<ItemDto> getTotalStockItems() {
		
		Set<ItemDto> itemDtoList = new HashSet<ItemDto>();
		List<Item> itemList = itemRepository.findAll();
		itemList.forEach(item->{
			ItemDto itemDto = ItemConverter.itemEntityToDto(item);
			if(itemDtoList.isEmpty())
				itemDtoList.add(itemDto);
			else{
			itemDtoList.forEach(dto->{
				if(dto.getItemName() != null && item.getItemName().equalsIgnoreCase(dto.getItemName())){
					dto.setStock(dto.getStock()+item.getStock());
				}else {
					itemDtoList.add(itemDto);
				}
			});
			}
		});
		
		return itemDtoList;
//		Session session = sessionFactory.openSession();
//		Criteria itemCriteria = session.createCriteria(Item.class);
//		return itemCriteria.list();
	}

	@Override
	public List<ItemDto>  getItemsByName(String itemName) {
		
		List<ItemDto> list = new ArrayList<ItemDto>();
		List<Item> itemList = itemRepository.findByItemName(itemName);
		itemList.forEach(item->{
			list.add(ItemConverter.itemEntityToDto(item));
		});
		return list;
	}
}
