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
	
	public List<ItemIssued> findByIssuedDate(String startDate);
	
	public List<ItemIssued> findByPartyName(String partyName);
	
	public List<ItemIssued> findByFatherName(String fatherName);
	
	public List<ItemIssued> findByPartyNameAndFatherName(String partyName, String fatherName);
	
	public List<ItemIssued> findByItemNameAndPartyNameAndFatherName(String itemName, String partyName, String fatherName);
	
}
