package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PendencyReportDto;
import com.example.demo.entity.ItemIssued;
import com.example.demo.entity.ItemReceived;
import com.example.demo.repository.IssuedRepository;
import com.example.demo.repository.ReceivedRepository;
import com.example.demo.service.PendencyService;
import com.example.model.IssuedDetails;
@Service
public class PendencyServiceImpl implements PendencyService{

	@Autowired
	private IssuedRepository issuedRepository;
	
	@Autowired
	private ReceivedRepository receivedRepository;
	
	 

	private Set<IssuedDetails> getIssuedDetails(List<ItemIssued> itemIssueds) {
		Set<IssuedDetails> issuedDetails = new HashSet<IssuedDetails>();
		if(itemIssueds != null  && !itemIssueds.isEmpty()) {
			itemIssueds.forEach(itemIssued -> {
				IssuedDetails issuedDetail = new IssuedDetails();
				issuedDetail.setPartyName(itemIssued.getPartyName());
				issuedDetail.setFatherName(itemIssued.getFatherName());
				issuedDetail.setItemName(itemIssued.getItemName());
				issuedDetail.setSize(itemIssued.getSize());
				issuedDetail.setSite(itemIssued.getSite());
				issuedDetail.setMobile(itemIssued.getMobile());
				issuedDetails.add(issuedDetail);
			});
		}
		return issuedDetails;
	}

	@Override
	public List<PendencyReportDto> getPendencyReport(String partyName, String fatherName) {
		
		List<PendencyReportDto> pendencyReportList = new ArrayList<PendencyReportDto>();
		List<ItemIssued> itemIssueds = null;
		
		if(partyName == null && fatherName == null)
			itemIssueds = issuedRepository.findAll();
		if(partyName != null && fatherName == null)
			itemIssueds = issuedRepository.findByPartyName(partyName);
		if(partyName == null && fatherName != null)
			itemIssueds = issuedRepository.findByFatherName(fatherName);
		if(partyName != null && fatherName != null)
			itemIssueds = issuedRepository.findByPartyNameAndFatherName(partyName, fatherName);
		
		Set<IssuedDetails> issuedDetails = getIssuedDetails(itemIssueds);
		
		issuedDetails.forEach(issuedDetail -> {
			PendencyReportDto pendencyReport = new PendencyReportDto();
			
			//get issued Quantity
			List<ItemIssued> itemIssuedList = issuedRepository.findByItemNameAndPartyNameAndFatherName(issuedDetail.getItemName(), issuedDetail.getPartyName(), issuedDetail.getFatherName());
			Integer totalIssuedQuantity = 0;
			if(itemIssuedList != null && !itemIssuedList.isEmpty())
				for(ItemIssued itemIssued : itemIssuedList)
					totalIssuedQuantity = totalIssuedQuantity + itemIssued.getQuantity();
			
			// get received quantity
			List<ItemReceived> itemReceivedList = receivedRepository.findByItemNameAndPartyNameAndFatherName(issuedDetail.getItemName(), issuedDetail.getPartyName(), issuedDetail.getFatherName());
			Integer totalReceivedQuantity = 0;
			if(itemReceivedList != null && !itemReceivedList.isEmpty())
				for(ItemReceived itemReceived : itemReceivedList)
					totalReceivedQuantity = totalReceivedQuantity + itemReceived.getQuantity();
			
			// set pendency report data
			pendencyReport.setItemName(issuedDetail.getItemName());
			pendencyReport.setPartyName(issuedDetail.getPartyName());
			pendencyReport.setFatherName(issuedDetail.getFatherName());
			pendencyReport.setSite(issuedDetail.getSite());
			pendencyReport.setSize(issuedDetail.getSize());
			pendencyReport.setMobile(issuedDetail.getMobile());
			if(totalIssuedQuantity > totalReceivedQuantity) {
				pendencyReport.setQuantity(totalIssuedQuantity - totalReceivedQuantity);
				pendencyReportList.add(pendencyReport);
			}
		});
		
		return pendencyReportList;
	}

}
