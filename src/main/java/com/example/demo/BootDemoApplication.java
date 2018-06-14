package com.example.demo;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class BootDemoApplication {
	
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}
	
	@Bean  
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
	    return hemf.getSessionFactory();  
	}  
}
