package com.ust.rest.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

import com.ust.rest.model.Product;

class RespositoryTest {

	@Autowired
	private ProductRepo repository;
	@Test
	@Order(1)
	public void saveProductTest() {
	Product product=Product.builder()
			.id(1)
			.brand("Vaio Plus")
			.description("Smart Phone")
			.qty(10)
			.price(20000)
			.build();
	repository.save(product);
	Assertions.assertThat(product.getId()>0);
	}
	

	@Test
	@Order(2)
	public void getProductTest() {
		Product product = repository.findById(1L).get();
		System.out.println(product);
		Assertions.assertThat(product.getId()).isEqualTo(1L);
	}
	
	@Test
	@Order(3)
	public void getListOfProductsTest() {
		List<Product> products = repository.findAll();
		System.out.println(products);
//		Assertions.assertThat()
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateProductTest() {
		Product product = repository.findById(1L).get();
		product.setDescription("Novel Foldable Mobile");
		Product updatedProduct = repository.save(product);
		
		System.out.println(updatedProduct);
		Assertions.assertThat(updatedProduct.getDescription()).isEqualTo("Noval foldable Mobile");
	}
	
	
}
