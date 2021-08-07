package com.rakuten.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ReviewDAO;
import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Reviews;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDAO reviewDAo;
	
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public int addReviewToProduct(Reviews toBeSaved,int p_id) {
		Product p=productDAO.findById(p_id);
		toBeSaved.setPro(p);
		reviewDAo.save(toBeSaved);
		return toBeSaved.getId();
	}

	@Override
	public Reviews findById(int id) {
		return reviewDAo.findById(id);
	}

	@Override
	public void deleteById(int id) {
		reviewDAo.deleteById(id);
	}

	@Override
	public List<Reviews> findAll() {
	
		return reviewDAo.findAll();
	}

	@Override
	public List<Reviews> findByRatingGreaterThan(int rating) {
		
		return reviewDAo.findByRatingGreaterThan(rating);
	}

	@Override
	public List<Reviews> findByPid(int p_id) {
		Product p=productDAO.findById(p_id);
		
		return reviewDAo.findByPid(p);
	}

	
	
	

}
