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
import com.example.demo.dto.PendencyReportDto;
import com.example.demo.entity.ItemIssued;
import com.example.demo.entity.ItemStatus;
import com.example.demo.repository.IssuedRepository;
import com.example.demo.repository.ItemStockStatusRepository;
import com.example.demo.service.IssuedService;
import com.example.demo.service.ItemService;
import com.example.demo.service.PendencyService;
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
	
	@Autowired 
	private PendencyService pendencyService;
	
	@Autowired 
	private ItemStockStatusRepository itemStockStatusRepository;

	@Autowired
	private Util util;
	
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
		startDate = util.dateConverter(startDate);
		endDate   = util.dateConverter(endDate);

		List<ItemIssued> itemIssueds = itemIssuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqual(startDate, endDate);
		itemIssueds.forEach(itemIssued -> {
			ItemIssuedDto itemIssuedDto = itemIssuedConverter.entityToDto(itemIssued);
			all.add(itemIssuedDto);
		});
		return all;
	}

	@Override
	public List<String> getPartyNames() {
		List<String> names = new ArrayList<String>();
		List<PendencyReportDto> pendencyReportList = pendencyService.getPendencyReport(null, null);
		pendencyReportList.forEach(pendencyReport -> {
			names.add(pendencyReport.getPartyName());
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

	@Override
	public List<Integer> getAvailStock(String partyName, String fatherName, String itemName, String size, String site) {
 
		List<Integer> stockAvail = new ArrayList<Integer>();
		List<PendencyReportDto> pendencyReportList = null;
		Integer stockBal = 0;
		Integer siteBal = 0;
		
		if(itemName != null && size == null) {
			List<ItemStatus> itemStatuses = itemStockStatusRepository.findByItemName(itemName);
			for(ItemStatus itemStatus : itemStatuses) {
				stockBal = stockBal + itemStatus.getStock();
			}
		}else if(itemName != null && size != null){
			ItemStatus itemStatus = itemStockStatusRepository.findByItemNameAndSize(itemName, size);
			stockBal = stockBal + itemStatus.getStock();
		}
		
		if(partyName != null && fatherName != null && itemName != null && size == null && site == null) {
			 pendencyReportList = pendencyService.getPendencyReport(partyName, fatherName);
			 for(PendencyReportDto pendencyReportDto : pendencyReportList) {
				 if(itemName.equalsIgnoreCase(pendencyReportDto.getItemName()))
					 siteBal = siteBal + pendencyReportDto.getQuantity();
			  }
		}if(partyName != null && fatherName != null && itemName != null && size == null && site != null) {
			 pendencyReportList = pendencyService.getPendencyReport(partyName, fatherName);
			 for(PendencyReportDto pendencyReportDto : pendencyReportList) {
				 if(itemName.equalsIgnoreCase(pendencyReportDto.getItemName())  && site.equalsIgnoreCase(pendencyReportDto.getSite()))
					 siteBal = siteBal + pendencyReportDto.getQuantity();
			  }
		} else if(partyName != null && fatherName != null && itemName != null && size != null && site == null) {
			pendencyReportList = pendencyService.getPendencyReport(partyName, fatherName);
			 for(PendencyReportDto pendencyReportDto : pendencyReportList) {
				 if(itemName.equalsIgnoreCase(pendencyReportDto.getItemName()) && size.equalsIgnoreCase(pendencyReportDto.getSize()))
					 siteBal = siteBal + pendencyReportDto.getQuantity();
			  }
		}else if(partyName != null && fatherName != null && itemName != null && size != null && site != null) {
			pendencyReportList = pendencyService.getPendencyReport(partyName, fatherName);
			 for(PendencyReportDto pendencyReportDto : pendencyReportList) {
				 if(itemName.equalsIgnoreCase(pendencyReportDto.getItemName()) && size.equalsIgnoreCase(pendencyReportDto.getSize())
						 && site.equalsIgnoreCase(pendencyReportDto.getSite()))
					 siteBal = siteBal + pendencyReportDto.getQuantity();
			  }
		}
		stockAvail.add(stockBal);
		stockAvail.add(siteBal);
		return stockAvail;
	}

	 

}
