package com.acme.controller;

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

import com.acme.entity.Product;
import com.acme.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/products")
	public ResponseEntity<Product> saveCustomerHandler(@Valid @RequestBody Product product){
		
		Product savedProduct = productService.saveProduct(product);
		
		return new ResponseEntity<Product>(savedProduct,HttpStatus.CREATED);
		
	}
	@PutMapping("/products/{productId}")
	public ResponseEntity<Product> updateCustomerHandler(@Valid @RequestBody Product product,@PathVariable Integer productId){
		
		Product updatedPrdouct = productService.updateProduct(product, productId);
		
		return new ResponseEntity<Product>(updatedPrdouct,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getCustomerById(@PathVariable Integer productId){
		Product product = productService.getProduct(productId);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/products/{productId}")
	public String deleteCustomerHandler(@PathVariable Integer productId) {
		productService.deleteProuduct(productId);
		
		return "Product is Deleted";
	}

}
