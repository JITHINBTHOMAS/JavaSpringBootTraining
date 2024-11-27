package com.ust.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.rest.model.Product;
import com.ust.rest.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	public Product addProduct(Product prod) {
		return repo.save(prod); 
	}
	
	public List<Product> getProduct() {
		return repo.findAll();
	}
}
