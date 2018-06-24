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
	public List<PendencyReportDto> getPendencyReport(String partyName, String fatherName, String itemName, String size, String site) {
		
		if(partyName != null && (partyName.equalsIgnoreCase("null") || partyName.equalsIgnoreCase("")))
			partyName = null;
		if(fatherName != null && (fatherName.equalsIgnoreCase("null") || fatherName.equalsIgnoreCase("")))
			fatherName = null;
		if(itemName != null && (itemName.equalsIgnoreCase("null") || itemName.equalsIgnoreCase("")))
			itemName = null;
		if(size != null && (size.equalsIgnoreCase("null") || size.equalsIgnoreCase("")))
			size = null;
		if(site != null && (site.equalsIgnoreCase("null") || site.equalsIgnoreCase("")))
			site = null;
		
		List<PendencyReportDto> pendencyReportList = new ArrayList<PendencyReportDto>();
		List<ItemIssued> itemIssueds = null;
		
		if(partyName == null && fatherName == null && itemName == null && size == null && site == null)
			itemIssueds = issuedRepository.findAll();
		
		else if(partyName != null && fatherName == null && itemName == null && size == null && site == null)
			itemIssueds = issuedRepository.findByPartyName(partyName);
		
		else if(partyName == null && fatherName != null && itemName == null && size == null && site == null)
			itemIssueds = issuedRepository.findByFatherName(fatherName);
		
		else if(partyName == null && fatherName == null && itemName != null && size == null && site == null)
			itemIssueds = issuedRepository.findByItemName(itemName);
		
		else if(partyName != null && fatherName != null && itemName == null && size == null && site == null)
			itemIssueds = issuedRepository.findByPartyNameAndFatherName(partyName, fatherName);
		
		else if(partyName != null && fatherName != null && itemName != null && size == null && site == null)
			itemIssueds = issuedRepository.findByPartyNameAndFatherNameAndItemName(partyName, fatherName, itemName);
		
		else if(partyName != null && fatherName != null && itemName != null && size != null && site == null)
			itemIssueds = issuedRepository.findByPartyNameAndFatherNameAndItemNameAndSize(partyName, fatherName, itemName, size);
		
		else if(partyName != null && fatherName == null && itemName != null && size != null && site != null)
			itemIssueds = issuedRepository.findByPartyNameAndItemNameAndSizeAndSite(partyName, itemName, size, site);
		
		else if(partyName != null && fatherName != null && itemName != null && size != null && site != null)
			itemIssueds = issuedRepository.findByPartyNameAndFatherNameAndItemNameAndSizeAndSite(partyName, fatherName, itemName, size, site);
		
		else if(partyName == null && fatherName == null && itemName != null && size != null && site == null)
			itemIssueds = issuedRepository.findByItemNameAndSize(itemName, size);
		
		else if(partyName == null && fatherName == null && itemName != null && size != null && site != null)
			itemIssueds = issuedRepository.findByItemNameAndSizeAndSite(itemName, size, site);
		
		else if(partyName == null && fatherName == null && itemName == null && size == null && site != null)
			itemIssueds = issuedRepository.findBySite(site);
		
		else if(partyName == null && fatherName == null && itemName != null && size == null && site != null)
			itemIssueds = issuedRepository.findByItemNameAndSite(itemName, site);
		
		
		Set<IssuedDetails> issuedDetails = getIssuedDetails(itemIssueds);
		
		issuedDetails.forEach(issuedDetail -> {
			PendencyReportDto pendencyReport = new PendencyReportDto();
			
			//get issued Quantity
			List<ItemIssued> itemIssuedList = issuedRepository.findByItemNameAndPartyNameAndFatherNameAndSize(issuedDetail.getItemName(), issuedDetail.getPartyName(),
												issuedDetail.getFatherName(),issuedDetail.getSize());
			Integer totalIssuedQuantity = 0;
			//Map<Integer, String> mpa = 
			if(itemIssuedList != null && !itemIssuedList.isEmpty())
				for(ItemIssued itemIssued : itemIssuedList)
					totalIssuedQuantity = totalIssuedQuantity + itemIssued.getQuantity();
			
			// get received quantity
			List<ItemReceived> itemReceivedList = receivedRepository.findByItemNameAndPartyNameAndFatherNameAndSize(issuedDetail.getItemName(), issuedDetail.getPartyName(),
													issuedDetail.getFatherName(), issuedDetail.getSize());
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
