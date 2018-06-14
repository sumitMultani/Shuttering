package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ItemStatus;

/**
 * Created by sumit
 */
@Repository
public interface ItemStockStatusRepository extends JpaRepository<ItemStatus, Long>{
}
