package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.AgreementDto;
import com.example.demo.entity.Agreement;

@Component
public class AgreementConverter {

	public Agreement dtoToAgreementEntity(AgreementDto ageementDto) {
		return new Agreement(ageementDto.getId(), ageementDto.getDate(),
				ageementDto.getAggrementNo(), ageementDto.getPartyName(),
				ageementDto.getSiteName(), ageementDto.getItemName(),
				ageementDto.getLength(), ageementDto.getRate(),
				ageementDto.getPer(), ageementDto.getRentPerDay(),
				ageementDto.getItemNameBreakage(),
				ageementDto.getItemSizeBreakage(),
				ageementDto.getDamageChargesPerPc());
	}

	public AgreementDto agreementEntityToDto(Agreement ageementDto) {
		return new AgreementDto(ageementDto.getId(), ageementDto.getDate(),
				ageementDto.getAggrementNo(), ageementDto.getPartyName(),
				ageementDto.getSiteName(), ageementDto.getItemName(),
				ageementDto.getLength(), ageementDto.getRate(),
				ageementDto.getPer(), ageementDto.getRentPerDay(),
				ageementDto.getItemNameBreakage(),
				ageementDto.getItemSizeBreakage(),
				ageementDto.getDamageChargesPerPc());
	}

}
