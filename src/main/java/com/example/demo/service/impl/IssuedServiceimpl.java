package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.ItemIssuedConverter;
import com.example.demo.dto.ItemIssuedDto;
import com.example.demo.dto.ItemStatusDto;
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
				itemIssuedDto.setIssuedDate(util.dateConverter(itemIssuedDto.getIssuedDate()));
				List<ItemStatusDto> stockItems = itemService.getStockStatusItems();
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
	public List<ItemIssued> getIssuedRegister(String startDate, String  endDate, String partyName, String fatherName, String itemName) {
		
		if(startDate != null && (!startDate.contains("null") || !startDate.trim().contains("")))
			startDate = util.dateConverter(startDate);
		else 
			startDate = null;
		if(endDate != null && (!endDate.contains("null") || !endDate.trim().contains("")))
			endDate = util.dateConverter(endDate);
		else
			endDate = null;
		 if(partyName.contains("null"))
			 partyName = null;
		 if(fatherName.contains("null"))
			 fatherName = null;
		 if(itemName.contains("null"))
			 itemName = null;
		         
		List<ItemIssued> itemIssueds = new ArrayList<ItemIssued>();
		if(startDate == null &&  endDate == null &&   partyName == null &&   fatherName ==null   && itemName == null) 
			itemIssueds = itemIssuedRepository.findAll();
		if(startDate != null &&  endDate == null &&   partyName == null &&   fatherName ==null   && itemName == null) 
			itemIssueds = itemIssuedRepository.findAllByIssuedDateGreaterThanEqual(startDate);
		if(startDate != null &&  endDate != null &&   partyName == null &&   fatherName ==null   && itemName == null) 
			itemIssueds = itemIssuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqual(startDate, endDate);
		if(startDate != null &&  endDate != null &&   partyName != null &&   fatherName ==null   && itemName == null) 
			itemIssueds = itemIssuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndPartyName(startDate, endDate, partyName); 
		if(startDate != null &&  endDate != null &&   partyName != null &&   fatherName != null   && itemName == null) 
			itemIssueds = itemIssuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndPartyNameAndFatherName(startDate, endDate, partyName, fatherName); 
		if(startDate != null &&  endDate != null &&   partyName != null &&   fatherName != null   && itemName != null) 
			itemIssueds = itemIssuedRepository.findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndPartyNameAndFatherNameAndItemName(startDate, endDate, partyName, fatherName, itemName);
		if(startDate == null &&  endDate == null &&   partyName == null &&   fatherName ==null   && itemName != null) 
			itemIssueds = itemIssuedRepository.findByItemName(itemName);
		if(startDate == null &&  endDate == null &&   partyName != null &&   fatherName == null   && itemName == null) 
			itemIssueds = itemIssuedRepository.findByPartyName(partyName);
		if(startDate == null &&  endDate == null &&   partyName == null &&   fatherName !=null   && itemName == null) 
			itemIssueds = itemIssuedRepository.findByFatherName(fatherName);
		if(startDate == null &&  endDate == null &&   partyName != null &&   fatherName != null   && itemName == null) 
			itemIssueds = itemIssuedRepository.findByPartyNameAndFatherName(partyName, fatherName);
		if(startDate == null &&  endDate == null &&   partyName != null &&   fatherName != null   && itemName != null) 
			itemIssueds = itemIssuedRepository.findByPartyNameAndFatherNameAndItemName(partyName, fatherName, itemName);
		
		return itemIssueds;
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
		List<PendencyReportDto> pendencyReportList = pendencyService.getPendencyReport(null, null,null, null, null);
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
			 pendencyReportList = pendencyService.getPendencyReport(partyName, fatherName, itemName, size , site);
			 for(PendencyReportDto pendencyReportDto : pendencyReportList) {
					 siteBal = siteBal + pendencyReportDto.getQuantity();
			  }
		}if(partyName != null && fatherName != null && itemName != null && size == null && site != null) {
			 pendencyReportList = pendencyService.getPendencyReport(partyName, fatherName, itemName, size , site);
			 for(PendencyReportDto pendencyReportDto : pendencyReportList) {
					 siteBal = siteBal + pendencyReportDto.getQuantity();
			  }
		} else if(partyName != null && fatherName != null && itemName != null && size != null && site == null) {
			pendencyReportList = pendencyService.getPendencyReport(partyName, fatherName, itemName, size , site);
			 for(PendencyReportDto pendencyReportDto : pendencyReportList) {
					 siteBal = siteBal + pendencyReportDto.getQuantity();
			  }
		}else if(partyName != null && fatherName != null && itemName != null && size != null && site != null) {
			pendencyReportList = pendencyService.getPendencyReport(partyName, fatherName, itemName, size , site);
			 for(PendencyReportDto pendencyReportDto : pendencyReportList) {
					 siteBal = siteBal + pendencyReportDto.getQuantity();
			  }
		}
		stockAvail.add(stockBal);
		stockAvail.add(siteBal);
		return stockAvail;
	}

	@Override
	public List<String> getItemNames() {
		List<String> names = new ArrayList<String>();
		List<PendencyReportDto> pendencyReportList = pendencyService.getPendencyReport(null, null,null, null, null);
		pendencyReportList.forEach(pendencyReport -> {
			names.add(pendencyReport.getItemName());
		});
		return names;
	}

	@Override
	public List<String> getItemSize(String itemname) {
		List<String> names = new ArrayList<String>();
		List<PendencyReportDto> pendencyReportList = pendencyService.getPendencyReport(null, null,null, null, null);
		pendencyReportList.forEach(pendencyReport -> {
			if(pendencyReport.getItemName().equalsIgnoreCase(itemname))
				names.add(pendencyReport.getSize());
		});
		return names;
	}

	 

}
