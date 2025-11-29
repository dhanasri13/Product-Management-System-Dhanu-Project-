package com.Dhanu.ProductsManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dhanu.ProductsManagementSystem.Model.Products;
import com.Dhanu.ProductsManagementSystem.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

//    private List<Products> products = new ArrayList<>();

	public Products createProduct(Products product) {

		return repository.save(product);
	}

	public List<Products> getProducts() {

		return repository.findAll();
	}

	public List<Products> findByCategory(String category) {

		return repository.findByCategory(category);
	}

	public Products getProductById(long id) {

		return repository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
	}

	public Products updateProduct(long id, Products product) {

		Products existingProduct = getProductById(id);

		existingProduct.setName(product.getName());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setAvailable(product.isAvailable());
		
		return repository.save(existingProduct);

	}
	
	public String  deleteProduct(long id) {
		
		 repository.deleteById(id);
		 
		 return "Product Deleted";
	}
}
