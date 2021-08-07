package com.rakuten.training.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductService;

//A contoller class manages HTTP request

@CrossOrigin
@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping(method =RequestMethod.GET, value="/products")
	public List<Product> getAllProducts(){
		return service.findAll();
		}
	
	@GetMapping(value="/products/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id") int id) {
		Product p=service.findById(id);
		if(p!=null) return new ResponseEntity<Product>(p,HttpStatus.FOUND);
		
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/products")
	public ResponseEntity addNewProduct(@RequestBody Product toBeSaved) {
		try {
			int id=service.addNewProduct(toBeSaved);
			HttpHeaders headers=new HttpHeaders();
			headers.setLocation(URI.create("/products/"+id));
			return new ResponseEntity(toBeSaved,headers,HttpStatus.CREATED);
		}
		catch(IllegalArgumentException e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity removeExisting(@PathVariable("id") int id) {
		try {
			Product p=service.findById(id);
			if(p==null) {
				return new ResponseEntity("Product not found!",HttpStatus.NOT_FOUND);
			}
			else {
				service.removeExisting(id);
				
//				HttpHeaders headers=new HttpHeaders();
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
		    }
		catch(IllegalStateException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	
	
	
	
//	Although I m returning Java Objects but Jackson libraries will convert it to JSON before returning
// @RestControllerAdvice google for it for translating user defined exception

}
