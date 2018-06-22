package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ItemReceived;

/**
 * Created by sumit
 */
@Repository
public interface ReceivedRepository extends JpaRepository<ItemReceived, Long>{
	
	public List<ItemReceived> findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqual(String startDate, String endDate);
	
	public List<ItemReceived> findByItemNameAndPartyNameAndFatherName(String itemName, String partyName, String fatherName);
	
	public List<ItemReceived> findByItemNameAndPartyNameAndFatherNameAndSize(String itemName, String partyName, String fatherName, String size);
}
