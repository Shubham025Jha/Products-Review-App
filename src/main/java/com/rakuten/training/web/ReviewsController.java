package com.rakuten.training.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.domain.Reviews;
import com.rakuten.training.service.ReviewService;

@RestController
public class ReviewsController {
	
	@Autowired
	ReviewService service;
	
	@PostMapping(value="product/{id}/reviews")
	public ResponseEntity addReviewToProduct(@RequestBody Reviews toBeSaved ,@PathVariable("id") Integer id) {
		int k=service.addReviewToProduct(toBeSaved, id.intValue());
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(URI.create("/reviews/"+k));
		
		return new ResponseEntity(toBeSaved,headers,HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="product/{id}/reviews")
	public ResponseEntity allReviewsForAProduct(@PathVariable("id")Integer id) {
		List<Reviews> ar=service.findByPid(id);
		
		if(ar.size()!=0)
		return new ResponseEntity(ar,HttpStatus.FOUND);
		
		else
			return new ResponseEntity("No Reviews yet!!",HttpStatus.NOT_FOUND);
	}

}
