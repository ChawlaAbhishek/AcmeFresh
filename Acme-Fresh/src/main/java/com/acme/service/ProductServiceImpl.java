package com.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.entity.Product;
import com.acme.exceptions.ResourceNotFoundException;
import com.acme.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product saveProduct(Product product) {
		
		return productDao.save(product);
	}

	@Override
	public Product updateProduct(Product product, Integer id)throws ResourceNotFoundException {
     Product existedProduct = productDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Product does not exist with product id"+":"+id));
		
		existedProduct.setName(product.getName());
		
		
	  return productDao.save(existedProduct);
	}

	@Override
	public void deleteProuduct(Integer id)throws ResourceNotFoundException {
		
	     Product product = productDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Product does not exist with product id"+":"+id));
	     
	      productDao.delete(product);
	}

	@Override
	public Product getProduct(Integer id)throws ResourceNotFoundException {
		
	     Product product = productDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Product does not exist with product id"+":"+id));

		return product;
	}

}
