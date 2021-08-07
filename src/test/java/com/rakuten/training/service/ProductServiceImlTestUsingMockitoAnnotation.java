package com.rakuten.training.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;

//AAA Arrange-Act-Assert
@ExtendWith(MockitoExtension.class)
class ProductServiceImlTestUsingMockitoAnnotation {
	
	@Mock
	ProductDAO mockDaoTest;
	
	@Test
	void testaddNewProduct_usingAMockForSuccessfulInsertion() {
		
		Product p=new Product("Nike",50f,500);
		Product saved=new Product();
		saved.setId(1);
		
		Mockito.when(mockDaoTest.save(p)).thenReturn(saved);
		
		ProductServiceImpl serviceTest=new ProductServiceImpl();
		serviceTest.setDao(mockDaoTest);
		
		int k=serviceTest.addNewProduct(p);
		
			assertTrue(k>0);
			
		
	}
}
