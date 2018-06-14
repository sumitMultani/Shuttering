package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AgreementDto;
import com.example.demo.service.AgreementService;

@RequestMapping("/agreement")
@RestController
public class AgreementController {
	
	@Autowired
	private AgreementService aggreementService;

	@RequestMapping(method = RequestMethod.POST)
	public AgreementDto saveAgreement(@RequestBody AgreementDto agreementDtos) {
		return aggreementService.saveAgreement(agreementDtos);
	}
}
