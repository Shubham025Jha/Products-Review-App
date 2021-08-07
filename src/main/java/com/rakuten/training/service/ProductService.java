package com.rakuten.training.service;

import java.util.List;

import com.rakuten.training.domain.Product;

public interface ProductService {
 
	public int addNewProduct(Product toBeAdded);
	public void removeExisting(int id);

	public List<Product> findAll();
	public Product findById(int id);
	
	public List<Product> findByPriceLessThan(float price);
	public List<Product> findByName(String Name);
}
