package com.rakuten.training.service;

import java.util.List;

import com.rakuten.training.domain.Reviews;

public interface ReviewService {

	int addReviewToProduct(Reviews toBeSaved, int p_id);
	
	public List<Reviews> findAll();

	Reviews findById(int id);

	void deleteById(int id);
	
	public List<Reviews> findByRatingGreaterThan(int rating);
	public List<Reviews> findByPid(int p_id);

}