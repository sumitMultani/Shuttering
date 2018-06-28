package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.AgreementConverter;
import com.example.demo.dto.AgreementDto;
import com.example.demo.repository.AgreementRepository;
import com.example.demo.service.AgreementService;

@Service
public class AgreementServiceImpl implements AgreementService {

	@Autowired
	private AgreementRepository agreementRepository;

	@Autowired
	private AgreementConverter agreementConverter;

	@Override
	public AgreementDto saveAgreement(AgreementDto[] agreementDtos) {
		AgreementDto agreementDto = agreementDtos[0];
		return agreementConverter.agreementEntityToDto(agreementRepository
				.save(agreementConverter.dtoToAgreementEntity(agreementDto)));
	}

}
