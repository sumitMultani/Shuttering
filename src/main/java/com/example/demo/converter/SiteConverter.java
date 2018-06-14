package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.SiteDto;
import com.example.demo.entity.Site;

@Component
public class SiteConverter {

	public Site siteDtoToEntity(SiteDto siteDto) {
		return new Site(siteDto.getSiteId(), siteDto.getSiteName(),
				siteDto.getAddress(), siteDto.getCity(),
				siteDto.getSupervisiorName(), siteDto.getSupervisiorPhone());
	}

	public SiteDto siteEntityToDto(Site site) {
		return new SiteDto(site.getSiteId(), site.getSiteName(),
				site.getAddress(), site.getCity(), site.getSupervisiorName(),
				site.getSupervisiorPhone());
	}
}
