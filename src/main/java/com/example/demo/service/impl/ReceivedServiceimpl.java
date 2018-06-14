package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.ItemConverter;
import com.example.demo.converter.ItemReceivedConverter;
import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ItemReceivedDto;
import com.example.demo.entity.ItemStatus;
import com.example.demo.entity.ItemIssued;
import com.example.demo.entity.ItemReceived;
import com.example.demo.repository.ReceivedRepository;
import com.example.demo.service.ItemService;
import com.example.demo.service.ReceivedService;

/**
 * Created by sumit
 */
@Service
public class ReceivedServiceimpl implements ReceivedService {

	@Autowired
	private ReceivedRepository receivedRepositry;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ItemService itemService;

	@Override
	public List<ItemReceived> saveReceivedItem(List<ItemReceivedDto> itemReceivedDtos) {

		
			List<ItemReceived> receivedItems = new ArrayList<ItemReceived>();
			Session session = sessionFactory.openSession();
		 	Map<String,Integer> issuedItem = new LinkedHashMap<String,Integer>();
		 	Map<String,Integer> receivedItem = new LinkedHashMap<String,Integer>();
		 	
		 	// get issued item name and quantity.
			Criteria issuedCriteria = session.createCriteria(ItemIssued.class);
			issuedCriteria.add(Restrictions.and(
					Restrictions.eq("partyName", itemReceivedDtos.get(0).getPartyName()),
					Restrictions.eq("fatherName", itemReceivedDtos.get(0).getFatherName())));
			List<?> list = issuedCriteria.list();
			if(list != null && !list.isEmpty()){
				for(Object obj : list) {
					ItemIssued itemIssued = (ItemIssued)obj;
					issuedItem.put(itemIssued.getItemName(), itemIssued.getQuantity());
				}
			}
			
			ItemReceivedDto receivedDto = null; 
			// save received item to db.
			if (itemReceivedDtos != null && !itemReceivedDtos.isEmpty()) {
				for (ItemReceivedDto itemReceivedDto : itemReceivedDtos) {
					receivedDto = itemReceivedDto;
					// save items to received item
					ItemReceived item = receivedRepositry.save(ItemReceivedConverter.dtoToEntity(itemReceivedDto));
					receivedItem.put(itemReceivedDto.getItemName(), itemReceivedDto.getQuantity());
					receivedItems.add(item);
				}
			// update stock item data
			for (Map.Entry<String, Integer> entry : receivedItem.entrySet())
			{
			    System.out.println(entry.getKey() + "/" + entry.getValue());
			    Criteria itemCriteria = session.createCriteria(ItemStatus.class);
			    itemCriteria.add(Restrictions.eq("itemName", entry.getKey()));
			    List<?> list2 = itemCriteria.list();
			    ItemStatus Item = (ItemStatus)list2.get(0);
			    Integer newStock = Item.getStock()+ entry.getValue();
			    Item.setStock(newStock);
			    if(receivedDto != null){
			    	Item.setBrokerCharges(receivedDto.getBreakage());
			    	Item.setShortage(receivedDto.getShortage());
			    }
			    ItemDto itemDto = ItemConverter.itemStatusEntityToDto(Item);
				itemService.updateItem(itemDto, Item.getItemId(), entry.getValue(), null);
			}
			 
		}
			
		// update stock status for Received items.
		//stock_status	
			
		return receivedItems;
	}

	@Override
	public List<ItemReceived> getReceivedRegister() {
		
		Session session = sessionFactory.openSession();
		Criteria issuedCriteria = session.createCriteria(ItemReceived.class);
		return issuedCriteria.list();
		
	}

}
