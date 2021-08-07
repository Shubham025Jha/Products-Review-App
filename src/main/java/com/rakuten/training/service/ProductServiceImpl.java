package com.rakuten.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	ProductDAO dao;//= new ProductDAOInMemImpl();
	
	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public int addNewProduct(Product toBeAdded) {
		if(toBeAdded.getPrice()*toBeAdded.getQoh()>10000) {
			Product saved=dao.save(toBeAdded);
			return saved.getId();
			
		}
		else {
			throw new IllegalArgumentException("The $ value is less");
		}
		
	}
    
	@Override
	public void removeExisting(int id) {
		
		Product toBeAdded=dao.findById(id);
		
		if(toBeAdded.getPrice()*toBeAdded.getQoh()<10000) {
			dao.deleteById(id);
		}else {
			throw new IllegalStateException("Product value more than 100000");
		}
		
	}
    
	@Override
	public List<Product> findAll() {
		
		return dao.findAll();
	}
	
	
    @Override
	public Product findById(int id) {
		
		return dao.findById(id);
	}

	
	
	@Override
	public List<Product> findByPriceLessThan(float price) {
		
		return dao.findByPriceLessThan(price);
	}

	@Override
	public List<Product> findByName(String Name) {
	    return dao.findByName(Name);
	}
 
	
}
