package com.rakuten.training.web;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductService;

class WrongWayToTestRestController {

	@Test
	void GetByIdTest() {
		Product pro=new Product("Test",200,1000);
		pro.setId(1);
		ProductService mockService=Mockito.mock(ProductService.class);
		Mockito.when(mockService.findById(1)).thenReturn(pro);
		
		ProductController objUnderTest=new ProductController();
		objUnderTest.service=mockService;
		
		ResponseEntity<Product> result=objUnderTest.getById(1);
		
		assertTrue(result.getStatusCode()==HttpStatus.FOUND);
	}

}

//Here we are not checking wether cirrect mapping is done and correct JSON results are sent back by the controller
//we are treating the product controller as POJO. Which is not our motive to test
