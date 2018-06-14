package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ItemReceived;

/**
 * Created by sumit
 */
@Repository
public interface ReceivedRepository extends JpaRepository<ItemReceived, Long>{
}
