package com.Dhanu.ProductsManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Dhanu.ProductsManagementSystem.Model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

	
	List<Products> findByCategory(String category);
}
