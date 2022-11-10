package com.acme.service;

import com.acme.entity.Product;
import com.acme.exceptions.ResourceNotFoundException;

public interface ProductService {
	
	Product saveProduct(Product product);
	
	Product updateProduct(Product product,Integer id) throws ResourceNotFoundException;
	
	void deleteProuduct(Integer id)throws ResourceNotFoundException;
	
	Product getProduct(Integer id)throws ResourceNotFoundException;
	

}
