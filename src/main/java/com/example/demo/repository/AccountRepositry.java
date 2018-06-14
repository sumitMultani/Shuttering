package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;

/**
 * Created by sumit
 */
@Repository
public interface AccountRepositry extends JpaRepository<Account, Long>{
	
}