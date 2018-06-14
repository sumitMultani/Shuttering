package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SiteDto;

public interface SiteService {

	public SiteDto saveSite(SiteDto siteDto);

	public List<SiteDto> getSites();

}
