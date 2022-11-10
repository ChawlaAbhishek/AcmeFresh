package com.acme.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acme.entity.Customer;
import com.acme.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomerHandler(@Valid @RequestBody Customer customer){
		
		Customer savedCustomer = customerService.saveCustomer(customer);
		
		return new ResponseEntity<Customer>(savedCustomer,HttpStatus.CREATED);
		
	}
	@PutMapping("/customers/{customerId}")
	public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody Customer customer,@PathVariable Integer customerId){
		
		Customer updatedCustomer = customerService.updateCustomer(customerId, customer);
		
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId){
		Customer customer = customerService.getCustomerById(customerId);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomersHandler(){
		List<Customer> customers = customerService.getAllCustomer();
		
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomerHandler(@PathVariable Integer customerId) {
		customerService.deleteCustomer(customerId);
		
		return "Customer is Deleted";
	}

}
