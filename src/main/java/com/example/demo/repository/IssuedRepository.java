package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ItemIssued;

/**
 * Created by sumit
 */
@Repository
public interface IssuedRepository extends JpaRepository<ItemIssued, Long>{
	
	//public List<ItemIssued> findByIssuedDate(String startDate);
 
	public List<ItemIssued> findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqual(String startDate, String endDate);
	
	public List<ItemIssued> findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndItemName(String startDate, String endDate, String itemName);
	
	public List<ItemIssued> findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndPartyName(String startDate, String endDate, String partyName);
	
	public List<ItemIssued> findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndFatherName(String startDate, String endDate, String fatherName);
	
	public List<ItemIssued> findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndItemNameAndPartyName(String startDate, String endDate, String itemName, String partyName);
	
	public List<ItemIssued> findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndItemNameAndPartyNameAndFatherName(String startDate, String endDate, String itemName, String partyName, String fatherName);
	
	public List<ItemIssued> findAllByIssuedDateGreaterThanEqualAndIssuedDateLessThanEqualAndPartyNameAndFatherName(String startDate, String endDate, String partyName, String fatherName);
	
	public List<ItemIssued> findByPartyName(String partyName);
	
	public List<ItemIssued> findByFatherName(String fatherName);
	
	public List<ItemIssued> findByPartyNameAndFatherName(String partyName, String fatherName);
	
	public List<ItemIssued> findByItemNameAndPartyNameAndFatherName(String itemName, String partyName, String fatherName);
	
	public List<ItemIssued> findByItemNameAndPartyNameAndFatherNameAndSize(String itemName, String partyName, String fatherName, String size);
	
}
