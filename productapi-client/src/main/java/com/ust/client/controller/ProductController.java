package com.ust.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ust.client.model.Product;

@RestController
@RequestMapping(value="/client/api1.0")
public class ProductController {
	
	@Autowired
	RestTemplate template;
	
	@GetMapping(value="/getAllProduct")
	public List<Product> fethProducts(){
		String url = "http://localhost:8090/product/api1.0/prodsinfo";
		List<Product> list = template.getForObject(url, List.class);
		return list;
	}
	
	@GetMapping(value="/getProductById/{id}")
	public Product fethById(@PathVariable long id){
		String url = "http://localhost:8090/product/api1.0/prod/"+id;
		Product prod = template.getForObject(url, Product.class);
		return prod;
	}
	
	@GetMapping(value="/getProductByBrand/{brand}")
	public ResponseEntity<List<Product>> fethByBrand(@PathVariable String brand){
		String url = "http://localhost:8090/product/api1.0/prod/Brand/"+brand;
		List<Product> prod = template.getForObject(url, List.class);
		if(prod.size()>0)
			return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(prod);
		else
			return  new ResponseEntity("Not items found",HttpStatus.NOT_FOUND);
	}
	
//	@PostMapping(value="/addNewProduct")
//	public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
//		String url = "http://localhost:8090/product/api1.0/addProduct";
//		ResponseEntity<Product> list = template.postForObject(url, Product.class, `, null);
//		
//	}
}
