package com.Dhanu.ProductsManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Dhanu.ProductsManagementSystem.Model.Products;
import com.Dhanu.ProductsManagementSystem.Service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/addproducts")
	public Products createProduct(@RequestBody Products product) {

		Products createProduct = service.createProduct(product);
		System.out.println("created products:" + createProduct);
		return createProduct;
	}

	@GetMapping("/getAll")
	public List<Products> getProducts() {
		return service.getProducts();
	}

	@GetMapping("/category/{category}")
	public List<Products> findByCategory(@PathVariable("category") String category) {

		return service.findByCategory(category);
	}
	@GetMapping("/id/{id}")
	public Products getProductById(@PathVariable("id") long id) {
		
		return service.getProductById(id);
	}
	@PutMapping("/update/{id}")
	public Products updateProduct(@PathVariable long id,@Valid @RequestBody Products product) {
		 
		return service.updateProduct(id, product);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable long id) {
		
		service.deleteProduct(id);
		
		return "Product Deleted";
	}
}