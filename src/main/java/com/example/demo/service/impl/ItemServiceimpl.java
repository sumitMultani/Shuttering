package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
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
	public List<ItemDto> getStockStatusItems() {
		return itemStatusRepository.findAll().stream()
				.map(ItemConverter::itemStatusEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public ItemStatus updateItem(ItemDto itemDto, Long itemId,
			Integer receivedQuantity, Integer issuedQuantity) {
		ItemStatus item = null;
		Transaction tx = null;
		try {
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			ItemDto entityDto = ItemConverter
					.itemStatusEntityToDto(itemStockStatusRepository
							.getOne(itemId));
			if (entityDto != null)
				itemDto.setItemId(entityDto.getItemId());
			if (issuedQuantity != null)
				itemDto.setIssued(issuedQuantity);
			 
			if(receivedQuantity != null) {
			if(entityDto.getReceived() != null)
				itemDto.setReceived(entityDto.getReceived() + receivedQuantity);
			else
				itemDto.setReceived(0 + receivedQuantity);
		    }
			if(entityDto.getIssued() != null ) {
				itemDto.setIssued(entityDto.getIssued());
				itemDto.setBrokerCharges(entityDto.getBrokerCharges());
			}
			if(entityDto!= null) {
				Integer brokerCharges = entityDto.getBrokerCharges();
				Integer shortage = entityDto.getShortage();
				if(brokerCharges != null ){
					itemDto.setBrokerCharges(brokerCharges+itemDto.getBrokerCharges());
				}else
					itemDto.setBrokerCharges(itemDto.getBrokerCharges());
				if(shortage != null){
					itemDto.setShortage(shortage + itemDto.getShortage());
				}else
					itemDto.setShortage(itemDto.getShortage());
			}
			item = ItemConverter.dtoToItemStatusEntity(itemDto);
			session.update(item);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		return item;
	}

	@Override
	public List<Item> addItem(List<ItemDto> itemDtos) {
		List<Item> items = new ArrayList<Item>();
		List<ItemStatus> itemsStatus = new ArrayList<ItemStatus>();
		if (itemDtos != null && !itemDtos.isEmpty()) {
			for (ItemDto itemDto : itemDtos) {
				String size = "";
				if(itemDto.getLength() != null && itemDto.getWidth() != null)
					size = itemDto.getLength().toString()+"*"+itemDto.getWidth();
				if(itemDto.getPer().equalsIgnoreCase("foot") && itemDto.getLength() != null )
					size = itemDto.getLength()+"ft";
				itemDto.setSize(size);
				Item item = itemRepository.save(ItemConverter.dtoToItemEntity(itemDto));
				items.add(item);
				ItemStatus itemStatus = itemStatusRepository.save(ItemConverter.dtoToItemStatusEntity(itemDto));
				itemsStatus.add(itemStatus);
			}
		}
		return items;
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
	public ItemStatus addTempItem(ItemDto itemDto) {
		ItemStatus item = ItemConverter.dtoToItemStatusEntity(itemDto);
		return item;
	}

	@Override
	public List<String> getNames() {
		List<String> names = new ArrayList<String>();
		List<ItemDto> allItems = itemService.getStockStatusItems();
		if (allItems != null && !allItems.isEmpty()) {
			for (ItemDto itemDto : allItems) {
				names.add(itemDto.getItemName());
			}
		}
		return names;
	}

	@Override
	public List<String> getSizes() {
		List<String> sizes = new ArrayList<String>();
		List<ItemDto> allItems = itemService.getStockStatusItems();
		if (allItems != null && !allItems.isEmpty()) {
			for (ItemDto itemDto : allItems) {
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
