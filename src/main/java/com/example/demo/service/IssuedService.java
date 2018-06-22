package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ItemIssuedDto;
import com.example.demo.entity.ItemIssued;

/**
 * Created by sumit
 */
public interface IssuedService {

	List<ItemIssued> saveItem(List<ItemIssuedDto> itemIssuedDtos);

	List<ItemIssued> getIssuedRegister();

	List<ItemIssuedDto> getIssuedFilterByDate(String startDate, String endDate);

	List<String> getPartyNames();

	List<String> getFatherNames(String partyName);

	List<String> getSites(String partyName, String fatherName);

	List<Integer> getAvailStock(String partyName, String fatherName, String itemname, String size, String site);

	 
    
}
