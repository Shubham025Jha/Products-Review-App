package com.rakuten.training.ui;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductService;

@Component("product_app")
public class Product_app {
 	
		ProductService obj;//=new ProductServiceImpl();
		
		@Autowired
		public void setObj(ProductService obj) {
			this.obj = obj;
		}
		
		public void createProductWithUI() {
			
			
	    try{	
	    	Scanner sc= new Scanner(System.in);
		String name; float price; int quantity;
		
		System.out.println("Enter Products Name: ");
		 name=sc.nextLine();
		 System.out.println("Enter Price of Product: ");
		 price=Float.parseFloat(sc.nextLine());
		 System.out.println("Enter Quantity: ");
		 quantity=Integer.parseInt(sc.nextLine());
		
		
		
		Product p=new Product(name,price,quantity);
		
		
		System.out.println("Created Product with Id: "+ obj.addNewProduct(p));
		
	List<Product> li=obj.findAll();
		
		if(li!= null)
	   System.out.println(li.get(0).getName());
			
		else
			System.out.println("Implement find all in DAO");
	    }
	    catch(Exception e) {
	    	
	    }
		
}

}
