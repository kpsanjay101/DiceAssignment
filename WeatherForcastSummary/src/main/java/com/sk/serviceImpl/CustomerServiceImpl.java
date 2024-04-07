package com.sk.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.exception.CustomerAlreadyExistsException;
import com.sk.model.Customer;
import com.sk.repository.CustomerRepository;
import com.sk.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer registerAdmin(Customer customer) {
		Customer existingAdminOptional = customerRepository.findByEmail(customer.getEmail());

	       if (existingAdminOptional!=null) {
	           throw new CustomerAlreadyExistsException("Customer already exists with this email: " + customer.getEmail());
	       }

	      
	       return customerRepository.save(customer);
	}

}
