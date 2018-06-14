package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Item;

/**
 * Created by sumit
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	
	public List<Item> findByItemName(String itemname);
}
