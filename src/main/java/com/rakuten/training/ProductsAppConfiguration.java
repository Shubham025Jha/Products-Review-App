//package com.rakuten.training;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import dal.ProductDAO;
//import dal.ProductDAOInMemImpl;
//import service.ProductService;
//import service.ProductServiceImpl;
//import ui.Product_app;
//
//@Configuration 
//public class ProductsAppConfiguration {
//
//	@Bean //objects that are created by spring container
//	public ProductDAO daoObj() {
//		ProductDAOInMemImpl dao= new ProductDAOInMemImpl();
//		return dao;
//	}
//	 
//	@Bean
//	public ProductService service() {
//		ProductServiceImpl ser=new ProductServiceImpl();
//		ser.setDao(daoObj());
//		
//		return ser;
//	}
//	@Bean
//	public Product_app ui() {
//		Product_app userI=new Product_app();
//		userI.setObj(service());
//		
//		return userI;
//	}
//	
//}
