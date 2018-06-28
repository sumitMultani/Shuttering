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
	
	public List<ItemReceived> findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndItemName(String startDate,String endDate,String itemName);

	public List<ItemReceived> findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndItemNameAndPartyName(String startDate,String endDate,String itemName,String partyName);

	public List<ItemReceived> findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndItemNameAndPartyNameAndFatherName(String startDate,String endDate,String itemName,String partyName,String fatherName);

	public List<ItemReceived> findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndPartyName(String startDate,String endDate,String partyName);

	public List<ItemReceived> findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndPartyNameAndFatherName(String startDate, String endDate, String partyName, String fatherName);
	
	public List<ItemReceived> findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndItemNameAndPartyNameAndFatherNameAndSize(String startDate,String endDate,String itemName,String partyName,String fatherName,String size);

	public List<ItemReceived> findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndItemNameAndPartyNameAndFatherNameAndSizeAndSite(String startDate,String endDate,String itemName,String partyName,String fatherName,String size,String site);

	public List<ItemReceived> findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndSite(String startDate,String endDate,String site);

	public List<ItemReceived> findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndItemNameAndSite(String startDate,String endDate,String itemName,String site);

	public List<ItemReceived> findAllByReceivedDateGreaterThanEqual(String startDate);
	
	public List<ItemReceived> findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqualAndPartyNameAndFatherNameAndItemName(String startDate, String endDate, String partyName,String fatherName, String itemName);
	
	public List<ItemReceived> findByItemName(String itemName);
	
	public List<ItemReceived> findByPartyName(String partyName);
	
	public List<ItemReceived> findByFatherName(String fatherName);
	
	public List<ItemReceived> findByPartyNameAndFatherName(String partyName, String fatherName);
	
	public List<ItemReceived> findByPartyNameAndFatherNameAndItemName(String partyName, String fatherName, String itemName);
}
