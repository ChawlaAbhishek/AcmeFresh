package com.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
