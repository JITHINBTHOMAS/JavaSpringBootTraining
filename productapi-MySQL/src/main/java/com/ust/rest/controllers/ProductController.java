package com.ust.rest.controllers;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.rest.model.Product;
import com.ust.rest.services.ProductService;


@RestController
@RequestMapping("/product/api1.0")//root of resource or controller
public class ProductController {
	
	Logger logger = Logger.getLogger("ProductController.class"); 
	
	@Autowired
	private ProductService service;
	
	
	@GetMapping(value="/product/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getById(@PathVariable long id) {
		return null;
	}
	
	@GetMapping(value="/product/Brand/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getByBrand(@PathVariable String name) {
		return null;
	}
	
	@PostMapping(value = "/addProduct",consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		logger.info("Entered Post method"+product);
		Product savedProd = service.addProduct(product);
		logger.info("persisted product"+savedProd);
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(savedProd);
		
	}
	
	@PutMapping(value="/modify")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		return null;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deletePProduct(@PathVariable long id) {
		return null;
	}
	
	@GetMapping(value="/productsinfo")
	public ResponseEntity<List<Product>> displayProducts(){
		List<Product> option = service.getProduct();
		return  ResponseEntity.status(HttpStatusCode.valueOf(200)).body(option);
	}
	
}
