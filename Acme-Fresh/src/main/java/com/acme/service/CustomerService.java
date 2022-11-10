package com.acme.service;

import java.util.List;

import com.acme.entity.Customer;
import com.acme.exceptions.ResourceNotFoundException;

public interface CustomerService {
	
	Customer saveCustomer(Customer customer);
	
	Customer updateCustomer(Integer id, Customer customer)throws ResourceNotFoundException;
	
	Customer getCustomerById(Integer id) throws ResourceNotFoundException;
	
	List<Customer> getAllCustomer();
	
	void deleteCustomer(Integer id)throws ResourceNotFoundException;

}
