package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ItemStatus;

@Repository
public interface ItemStatusRepository extends JpaRepository<ItemStatus, Long> {
	
	
	public List<ItemStatus> findByItemName(String itemName);
	
}
