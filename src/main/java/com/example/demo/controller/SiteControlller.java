package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SiteDto;
import com.example.demo.service.SiteService;

@RequestMapping("/site")
@RestController
public class SiteControlller {

	@Autowired
	private SiteService siteService;

	@RequestMapping(method = RequestMethod.POST)
	public SiteDto saveSite(@RequestBody SiteDto siteDto) {
		System.out.println("ENter site POST-----------------------");
		return siteService.saveSite(siteDto);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<SiteDto> getSites() {
		System.out.println("ENter site GET-----------------------");
		return siteService.getSites();
	}
}
