package com.rakuten.training.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rakuten.training.domain.Product;

@Repository
public class ProductDAOInMemImpl implements ProductDAO{
	
	Map<Integer ,Product> map=new HashMap<Integer,Product>();
	int idSequence=0;
	public Product save(Product toBeSaved) {
		int id= ++idSequence;
		toBeSaved.setId(id);
		map.put(id, toBeSaved);
		return toBeSaved;
	}
	public List<Product> findAll() {		
		return new ArrayList<Product>(map.values());
	}
	public Product findById(int id) {
		return map.get(id);
	}
	public void deleteById(int id) {
		map.remove(id);
	}

}

//using JDBC we connect java to RDBMS, the RDBMS will also provide the driver to connect
//the most low level api to connect with database in java is JDBC
//java app wants data in form of objects, while RDMS has tables(this is paradime mismatch)
//JDBC returns data in tabular form and objects should be formed by you.
// ORM object relational mapping system (Hibernate in java(most popular)) maps tabular data to objects
//JPA java persistence API - all ORMs are inherited from this