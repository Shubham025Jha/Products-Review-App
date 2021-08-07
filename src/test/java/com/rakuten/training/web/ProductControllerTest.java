package com.rakuten.training.web;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers= {ProductController.class})
class ProductControllerTest {
	
	@MockBean
	ProductService serviceTest;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void testGetById() throws Exception {
		int id=5;
		Product pro=new Product("Test",200,1000);
		pro.setId(id);
	
		Mockito.when(serviceTest.findById(id)).thenReturn(pro);
		
		mockMvc
		      .perform(MockMvcRequestBuilders.get("/products/{id}", id))
		                        .andExpect(MockMvcResultMatchers.status().isFound())
		                        .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(id)));   
		
	}

}

//For JSON comparision use JSONPath , comparing strings is not the correct way
