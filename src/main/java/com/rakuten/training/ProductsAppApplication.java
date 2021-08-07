package com.rakuten.training;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rakuten.training.dal.ProductRepository;
import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Reviews;
import com.rakuten.training.service.ProductService;
import com.rakuten.training.service.ReviewService;
import com.rakuten.training.ui.Product_app;
import com.rakuten.training.ui.Review_app;

//@ComponentScan({"ui","com.rakuten.training.dal","com.rakuten.training.service","com.rakuten.training.domain"})
@SpringBootApplication
public class ProductsAppApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer= SpringApplication.run(ProductsAppApplication.class, args);
		
		
//		Product_app pro=springContainer.getBean(Product_app.class);
//	    pro.createProductWithUI();
	    
//	    testReviewOps(springContainer);
		
//		testProuctQueries(springContainer);
	    
//	    testRepository(springContainer);
		

	}
	
//All this time we actually made an interface implemented it and then created its bean pushed the injection and I was amazed that
//spring can do lots of thing and is so powerful.
//
//Imagine if I say, no need to do all these things, just create an Interface and spring will implement it and will also inject the dependencies
//No need to write a single line of code . All this is done by CrudRepository.
//Also search for     https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods on google to know more.

private static void testRepository(ApplicationContext springContainer) {
		ProductRepository repo=springContainer.getBean(ProductRepository.class);
		Product p=new Product("Bike",240000,3);
		
		repo.save(p);
	}
	// here in main we are using getBean method and not Autowired because main itself is not a bean
	//autowire can only be used in beans
	private static void testProuctQueries(ApplicationContext springContainer) {
		ProductService service = springContainer.getBean(ProductService.class);
		List<Product> all=service.findAll();
		System.out.println("There are "+all.size()+" products:");
		all.forEach(System.out::println);
		
		List<Product> allLessThan=service.findByPriceLessThan(900.0f);
		System.out.println("There are "+allLessThan.size()+" products with price less than 900:");
		allLessThan.forEach(System.out::println);
		
		List<Product> allOfName=service.findByName("Nike");
		System.out.println("There are "+allOfName.size()+" products with name as nike");
		allOfName.forEach(System.out::println);
		
	}

	private static void testReviewOps(ApplicationContext springContainer) {
		
		
		Review_app review=springContainer.getBean(Review_app.class);
        review.createReviewWithUI();
	    
	    ReviewService service=springContainer.getBean(ReviewService.class);
	    List<Reviews> r=service.findAll();
			    
	    System.out.println("There are "+r.size()+" reviews." );
	    r.forEach(System.out::println);
	    
	    List<Reviews> rGreaterThanRating=service.findByRatingGreaterThan(5);
	    System.out.println("There are "+rGreaterThanRating.size()+" reviews with rating greater than 5" );
	    rGreaterThanRating.forEach(System.out::println);
	    
	    List<Reviews> rByProductId=service.findByPid(3);
	    System.out.println("There are "+rByProductId.size()+" reviews for product id 3" );
	    rByProductId.forEach(System.out::println);
	}

}









//@ComponentScan will look for beans in specified packages.
// what i did was i changed the ui package name to ui from com.rakuten.training.ui  an you can see i had to mention the all the packages
//component scan

//In application property the first 4 lines gives location of database
  