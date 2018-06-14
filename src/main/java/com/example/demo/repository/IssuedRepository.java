package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ItemIssued;

/**
 * Created by sumit
 */
@Repository
public interface IssuedRepository extends JpaRepository<ItemIssued, Long>{
}
