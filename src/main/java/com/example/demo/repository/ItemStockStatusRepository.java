package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ItemStatus;

/**
 * Created by sumit
 */
@Repository
public interface ItemStockStatusRepository extends JpaRepository<ItemStatus, Long>{
	
	public List<ItemStatus> findByItemName(String itemName);
	
	public ItemStatus findByItemNameAndSize(String itemName, String size);
	
}
