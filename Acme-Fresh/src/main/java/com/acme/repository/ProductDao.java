package com.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	


}
