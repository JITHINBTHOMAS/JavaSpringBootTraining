package com.ust.rest.services;

import java.util.List;
import java.util.Optional;

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
	
	public Product getById(long id) {
		Optional<Product> optional =  repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else
			return null;
	}
	
	public String deleteById(Long id) {
		Product product = getById(id);
		if(product!=null) {
			repo.deleteById(id);
			return "Deleted : "+product;
		}
		else
			return "ID not found";
	}
	
	public String updateProduct(Product product) {
		long id = product.getId();
		if(getById(id)!=null) {
			repo.save(product);
			return "updated";
		}
		else
			return "";
	}
	
	public List<Product> getByBrand(String brand) {
		return repo.findByBrand(brand);
	}
}
