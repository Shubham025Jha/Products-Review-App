package com.rakuten.training.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ProductDAOInMemImpl;
import com.rakuten.training.domain.Product;


//testing with stub can be really difficult if the interface is large as stubs are actual classes.
//therefore better approach is to use mockito (Dynamic implementation of interface for testing)

class ProductServiceImplTestUsingStub {
	
	
	@Test
	void testaddNewProduct_usingInMemImpl() {
		ProductServiceImpl serviceTest=new ProductServiceImpl();
		ProductDAO daoTest=new ProductDAOInMemImpl();
		Product p=new Product("Nike",500f,500);
		
		serviceTest.setDao(daoTest);
		try {
		int k=serviceTest.addNewProduct(p);
		
			assertTrue(k>0);
		}
		catch(IllegalArgumentException e) {
			assert false;
		}
		
		
		
		
	}

}
