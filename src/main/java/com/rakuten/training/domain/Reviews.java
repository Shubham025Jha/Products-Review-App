package com.rakuten.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reviews {
	private int id;
	private String reviewer;
	private String details;
	private int rating;
	Product pro;
	
	@Override
	public String toString() {
		return "Reviews [id=" + id + ", reviewer=" + reviewer + ", details=" + details + ", rating=" + rating + ", pro="
				+ pro + "]";
	}

	@ManyToOne
	@JoinColumn(name="pid")
	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
	}

	public Reviews() {
		
	}
	
	public Reviews(String reviewer, String details, int rating) {
		super();
		this.reviewer = reviewer;
		this.details = details;
		
		if(rating>10) {
		int noOfDig= (int)Math.log10(rating);
		int k=(int)Math.pow(10.0, (double)noOfDig);
		
		this.rating = rating/k;}
		
		else
			this.rating=rating;
	}

	@Id
	@Column(name="review_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	
	@Column(name="review_details")
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		
		if (rating<10){
			this.rating=rating;
			return;
		}
		
		int noOfDig= (int)Math.log10(rating);
		int k=(int)Math.pow(10.0, (double)noOfDig);
		
		System.out.println(k+" "+noOfDig);
		
		this.rating = rating/k;
	}
	
	
	
	
}
