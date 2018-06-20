package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ItemReceivedDto;
import com.example.demo.entity.ItemReceived;
import com.example.demo.service.ReceivedService;

@RequestMapping("/received")
@RestController
public class ReceivedController {

	@Autowired
	private ReceivedService receivedService;
	
	@RequestMapping(method = RequestMethod.POST)
	public List<ItemReceived> saveItem(@RequestBody List<ItemReceivedDto> itemReceivedDtos) {
		return receivedService.saveReceivedItem(itemReceivedDtos);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public List<ItemReceived> getReceivedItem() {
		return receivedService.getReceivedRegister();
	}
	
//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public List<ItemReceived> getReceivedItem() {
//		return receivedService.getReceivedRegister();
//	}
	
}
