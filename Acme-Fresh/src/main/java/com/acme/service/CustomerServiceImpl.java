package com.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.entity.Customer;
import com.acme.exceptions.ResourceNotFoundException;
import com.acme.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer saveCustomer(Customer customer) {
		
		Customer savedCustomer = customerDao.save(customer);
		
		
		return savedCustomer;
	}

	@Override
	public Customer updateCustomer(Integer id, Customer customer) throws ResourceNotFoundException {
		
		Customer existedCustomer = customerDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer does not exist with customer id"+":"+id));
		
		existedCustomer.setName(customer.getName());
		existedCustomer.setEmail(customer.getEmail());
		existedCustomer.setPassword(customer.getPassword());

		
		Customer updatedCustomer = customerDao.save(existedCustomer);
		
		return updatedCustomer;
	}

	@Override
	public Customer getCustomerById(Integer id) throws ResourceNotFoundException {
		
		Customer customer = customerDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer does not exist with customer id"+":"+id));
		
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		List<Customer> customers = customerDao.findAll();
		
		return customers;
		
	}

	@Override
	public void deleteCustomer(Integer id) throws ResourceNotFoundException {
		
		Customer customer = customerDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer does not exist with customer id"+":"+id));
		
		customerDao.delete(customer);

		
	}

}
