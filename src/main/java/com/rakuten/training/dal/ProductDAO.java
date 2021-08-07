package com.rakuten.training.dal;

import java.util.ArrayList;
import java.util.List;

import com.rakuten.training.domain.Product;

public interface ProductDAO {

	public Product save(Product toBeSaved);
	public List<Product> findAll();
	public Product findById(int id);
	public void deleteById(int id);
	public default List<Product> findByPriceLessThan(float price){
		return new ArrayList();
	}
	public default List<Product> findByName(String Name){
		return new ArrayList();
	}
	public default List<Product> findByNameLike(String Name){
		return new ArrayList();
	}
	
}

