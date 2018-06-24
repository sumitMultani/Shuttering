package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PendencyReportDto;


public interface PendencyService {

	List<PendencyReportDto> getPendencyReport(String partyName, String fatherName, String itemName, String size, String site);

	 



}
