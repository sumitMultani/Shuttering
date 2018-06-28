package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.SiteConverter;
import com.example.demo.dto.SiteDto;
import com.example.demo.entity.Site;
import com.example.demo.repository.SiteRepository;
import com.example.demo.service.SiteService;

@Service
public class SiteServiceImpl implements SiteService {

	@Autowired
	private SiteRepository siteRepository;

	@Autowired
	private SiteConverter siteConverter;

	@Override
	public SiteDto saveSite(SiteDto siteDto) {
		Site siteEntity = siteConverter.siteDtoToEntity(siteDto);
		Site entity = siteRepository.save(siteEntity);
		return siteConverter.siteEntityToDto(entity);
	}

	@Override
	public List<String> getSites() {
		List<Site> siteList = siteRepository.findAll();
		List<String> sites = new ArrayList<String>();
		siteList.forEach(site -> {
			SiteDto dto = siteConverter.siteEntityToDto(site);
			sites.add(dto.getSiteName());
		});
		return sites;
	}

}
