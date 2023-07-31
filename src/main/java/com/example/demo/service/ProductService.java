package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import com.example.demo.entity.Product;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> getAllProducts(){
		return repository.findAll();
	}
	
	public void saveProduct(Product product) {
		repository.save(product);
	}
	
	public Product getProduct(Integer id) {
		return repository.findById(id).get();
	}
	
	public void deleteProduct(Integer id) {
		repository.deleteById(id);
	}
	
	public void updateProduct(Product product) {
		Product currProduct = repository.findById(product.getProductId()).get();
		currProduct.setProductName(product.getProductName());
		currProduct.setProductPrice(product.getProductPrice());
		repository.save(product);
	}
	
}
