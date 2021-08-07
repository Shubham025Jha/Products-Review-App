package com.rakuten.training.dal;

import java.util.List;

import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Reviews;

public interface ReviewDAO {

	public Reviews save(Reviews toBeSaved);
	public List<Reviews> findAll();
	public Reviews findById(int id);
	public void deleteById(int id);
	public List<Reviews> findByRatingGreaterThan(int rating);
	public List<Reviews> findByPid(Product p);
}
