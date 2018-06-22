package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ItemReceivedDto;
import com.example.demo.entity.ItemReceived;

/**
 * Created by sumit
 */
public interface ReceivedService {

	List<ItemReceived> saveReceivedItem(List<ItemReceivedDto> itemReceivedDtos);

	List<ItemReceived> getReceivedRegister();

	List<ItemReceivedDto> getReceivedFilterByDate(String startDate, String endDate);


	 
    
}
