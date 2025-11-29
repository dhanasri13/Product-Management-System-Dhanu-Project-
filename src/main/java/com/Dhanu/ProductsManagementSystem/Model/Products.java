package com.Dhanu.ProductsManagementSystem.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products_table")
@NoArgsConstructor
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "Product name cannot be empty")
	private String name;
	@NotBlank(message = "Product category cannot be empty")
	private String category;
	@NotNull(message = "Product price cannot be empty")
	@Min(value = 1, message = "price must be greater than 0")
	private double price;

	@Column(name = "is_available", nullable = false)
	private boolean available = true;

	public Products(String name, String category, double price, boolean available) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.available = available;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
