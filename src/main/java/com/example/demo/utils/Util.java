package com.example.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class Util {
	
	public   String dateConverter(String date){
		  date = date.replaceFirst("-", "/"); 
		  date = date.replaceFirst("-", "/"); 
		  return date;
	}

}
