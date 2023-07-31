package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/save")
	public void save(@RequestBody Product product) {
		service.saveProduct(product);
	}
	
	@GetMapping("/products")
	public List<Product> listAll(){
		return this.service.getAllProducts();
	}
	
	@GetMapping("/getproduct/{id}")
	public Product getProductById(@PathVariable Integer id) {
		return service.getProduct(id);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteProduct(id);
	}
	
	@PutMapping("/updateProduct")
	public void updateProduct(@RequestBody Product product){
		service.updateProduct(product);
	}
}
