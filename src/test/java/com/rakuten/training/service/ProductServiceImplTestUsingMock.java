package com.rakuten.training.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;


//Mocking is creating objects that simulate the behavior of real objects. Unlike stubs,mocks can be dynamically created from code-at runtime
//Mocks offers more functionality than stubbing. You can verify method calls and a lot of other things

 class ProductServiceImplTestUsingMock {
	
	
	@Test
	void testaddNewProduct_usingAMockForSuccessfulInsertion() {
		
		Product p=new Product("Nike",50f,500);
		Product saved=new Product();
		saved.setId(1);
		
		ProductDAO mockDaoTest=Mockito.mock(ProductDAO.class);
		Mockito.when(mockDaoTest.save(p)).thenReturn(saved);
		
		ProductServiceImpl serviceTest=new ProductServiceImpl();
		
		
		
		serviceTest.setDao(mockDaoTest);
		
		int k=serviceTest.addNewProduct(p);
		
			assertTrue(k>0);
			
		
	}
	
	@Test
	void testaddNewProduct_usingAMockForUnsuccessfulInsertion() {
		Product p=new Product("Nike",50f,50);
		
		ProductServiceImpl serviceTest=new ProductServiceImpl();
		
        assertThrows(IllegalArgumentException.class,()->serviceTest.addNewProduct(p));
		
//		try {
//			int k=serviceTest.addNewProduct(p);
//			
//			assertFalse(k>0);
//		}
//		catch(IllegalArgumentException e) {
//			assert true;
//		}
	}
	
	@Test
	void testRemoveExisting_usingMockForSuccessfulDeletion() {
		Product pro=new Product("Test",10,100);
		
		ProductDAO mockDaoTest=Mockito.mock(ProductDAO.class);
		Mockito.when(mockDaoTest.findById(1)).thenReturn(pro);
		
		ProductServiceImpl serviceTest=new ProductServiceImpl();
		serviceTest.setDao(mockDaoTest);
		
		
			serviceTest.removeExisting(1);
//			here we are unable to check if deleteById was called on the database, to do so we use Mockito.verify(null)
//			assert true;
			
			Mockito.verify(mockDaoTest).deleteById(1);
		
	}
	@Test
	void testRemoveExisting_usingMockForUnsuccessfulDeletion() {
		Product pro=new Product("Test",10,100000);
		
		ProductDAO mockDaoTest=Mockito.mock(ProductDAO.class);
		Mockito.when(mockDaoTest.findById(1)).thenReturn(pro);
		
		
		ProductServiceImpl serviceTest=new ProductServiceImpl();
		serviceTest.setDao(mockDaoTest);
		
		
		assertThrows(IllegalStateException.class,()->serviceTest.removeExisting(1));
		
	}
	

}
