package com.rakuten.training.ui;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakuten.training.domain.Reviews;
import com.rakuten.training.service.ReviewService;

@Component
public class Review_app {
 	
		ReviewService obj;
		
		@Autowired
		public void setObj(ReviewService obj) {
			this.obj = obj;
		}
		
		public void createReviewWithUI() {
			
			
	    try{		
	    	Scanner sc= new Scanner(System.in);
		String reviewer;
		String details;
		int rating;
		
		System.out.println("Enter Reviewer Name: ");
		 reviewer=(sc.nextLine());
		 System.out.println("Review Statement Please: ");
		 details=(sc.nextLine());
		 System.out.println("Enter Rating: ");
		 rating=Integer.parseInt(sc.nextLine());
		 System.out.println("Enter the product Id for the review");
		 int p_id=Integer.parseInt(sc.nextLine());
		
		
		
		Reviews r=new Reviews(reviewer,details,rating);
		
		
		System.out.println("Created Review with Id: "+ obj.addReviewToProduct(r,p_id));
		
	List<Reviews> li=obj.findAll();
		
		if(li!= null)
	   System.out.println(li);
			
		else
			System.out.println("No data in Reviews");
	    }
	    
	    catch(Exception e) {
	    	
	    }
		
}
}