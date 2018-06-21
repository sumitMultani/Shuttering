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
	
//	@Query("select ir from item_received ir where ir.received_date between :startDate and :endDate")
//	public List<ItemReceived> filterReceivedByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	public List<ItemReceived> findAllByReceivedDateGreaterThanEqualAndReceivedDateLessThanEqual(String startDate, String endDate);
	
	public List<ItemReceived> findByItemNameAndPartyNameAndFatherName(String itemName, String partyName, String fatherName);
}
