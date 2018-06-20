package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.ItemIssuedConverter;
import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ItemIssuedDto;
import com.example.demo.entity.ItemIssued;
import com.example.demo.entity.ItemStatus;
import com.example.demo.repository.IssuedRepository;
import com.example.demo.service.IssuedService;
import com.example.demo.service.ItemService;
import com.example.demo.utils.Util;

/**
 * Created by sumit
 */
@Service
public class IssuedServiceimpl implements IssuedService {

	@Autowired
	private IssuedRepository itemIssuedRepository;
	
	@Autowired
	private ItemIssuedConverter itemIssuedConverter;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ItemService itemService;

	@Override
	public List<ItemIssued> saveItem(List<ItemIssuedDto> itemIssuedDtos) {

		List<ItemIssued> items = new ArrayList<ItemIssued>();
		if (itemIssuedDtos != null && !itemIssuedDtos.isEmpty()) {
			itemIssuedDtos.forEach(itemIssuedDto -> {
				List<ItemDto> stockItems = itemService.getStockStatusItems();
				if (stockItems != null && !stockItems.isEmpty()) {
					stockItems.forEach(itemDto -> {
						if (itemDto.getItemName().equalsIgnoreCase(
								itemIssuedDto.getItemName())
								&& itemDto.getSize().equalsIgnoreCase(
										itemIssuedDto.getSize())
								&& itemIssuedDto.getQuantity() > 1
								&& itemDto.getStock() >= itemIssuedDto
										.getQuantity()) {
							// save data into issued Register.
							ItemIssued itemIssued = itemIssuedRepository
									.save(itemIssuedConverter
											.dtoToEntity(itemIssuedDto));

							// save and update data in stock Status.
							Integer newStock = itemDto.getStock()
									- itemIssuedDto.getQuantity();
							itemDto.setStock(newStock);
							ItemStatus updateItem = itemService.updateItem(
									itemDto, itemDto.getItemId(), null,
									itemIssuedDto.getQuantity());
							System.out.println("updated Item : " + updateItem);
							items.add(itemIssued);
						} 
					});

				}
			});
		}
		if(items == null || items.isEmpty())
			throw new RuntimeException("Stock not available");
		return items;
	}

	@Override
	public List<ItemIssued> getIssuedRegister() {
		Session session = sessionFactory.openSession();
		Criteria issuedCriteria = session.createCriteria(ItemIssued.class);
		return issuedCriteria.list();
	}

	@Override
	public List<ItemIssuedDto> getIssuedFilterByDate(String startDate, String endDate) {
		
		List<ItemIssuedDto> all = new ArrayList<ItemIssuedDto>();
		startDate = Util.dateConverter(startDate);
		List<ItemIssued> startDateData = itemIssuedRepository.findByIssuedDate(startDate);
		startDateData.forEach(date -> {
				ItemIssuedDto itemIssued = itemIssuedConverter.entityToDto(date);
				all.add(itemIssued);
			});
		
		endDate = Util.dateConverter(endDate);
		List<ItemIssued> endDateData = itemIssuedRepository.findByIssuedDate(endDate);
		endDateData.forEach(date -> {
			ItemIssuedDto itemIssued = itemIssuedConverter.entityToDto(date);
			all.add(itemIssued);
		});
		return all;
	}

	@Override
	public List<String> getPartyNames() {
		List<String> names = new ArrayList<String>();
		List<ItemIssued> itemIssueds = itemIssuedRepository.findAll();
		itemIssueds.forEach(itemIssued -> {
			names.add(itemIssued.getPartyName());
		});
		return names;
	}

	@Override
	public List<String> getFatherNames(String partyName) {
		List<String> fatherNames = new ArrayList<String>();
		List<ItemIssued> itemIssueds = itemIssuedRepository.findByPartyName(partyName);
		itemIssueds.forEach(itemIssued -> {
			fatherNames.add(itemIssued.getFatherName());
		});
		return fatherNames;
	}

	@Override
	public List<String> getSites(String partyName, String fatherName) {
		List<String> sites = new ArrayList<String>();
		List<ItemIssued> itemIssueds = itemIssuedRepository.findByPartyNameAndFatherName(partyName, fatherName);
		itemIssueds.forEach(itemIssued -> {
			sites.add(itemIssued.getSite());
		});
		return sites;
	}

	 

}
