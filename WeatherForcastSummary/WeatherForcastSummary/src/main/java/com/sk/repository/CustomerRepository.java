package com.sk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sk.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	 Customer findByEmail(String email);
}
