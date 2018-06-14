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

	 
    
}
