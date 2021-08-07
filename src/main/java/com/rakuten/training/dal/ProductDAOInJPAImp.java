package com.rakuten.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.domain.Product;

@Primary
@Repository
@Transactional
public class ProductDAOInJPAImp implements ProductDAO {
	
	@Autowired
	EntityManager em;
	
	@Override
	public Product save(Product toBeSaved) {
		//toBeSaved---------- new/Transient 
		em.persist(toBeSaved);
		//toBeSaved---------- Persistent ... the primary key is alloted automatically
		
		return toBeSaved;
	}

	@Override
	public List<Product> findAll() {
		
		Query q=em.createQuery("select p from Product as p");
		return q.getResultList();
	}

	@Override
	public Product findById(int id) {
	
		return em.find(Product.class, id);
	}

	@Override
	public void deleteById(int id) {
		Product p= findById(id);
		if(p!= null ) {
			em.remove(p);
		}
		
	}

	@Override
	public List<Product> findByPriceLessThan(float price) {
	    Query q=em.createQuery("select p from Product as p where p.price<:p");
	    q.setParameter("p", price);
	    return q.getResultList();
	}

	@Override
	//Do not use string concatination for sql queries use prameterized string as shown
	//refer sql injection attack to know the problem
	public List<Product> findByName(String Name) {
		Query q=em.createQuery("select p from Product as p where p.name=:n");
		q.setParameter("n", Name);
	    return q.getResultList();
	}

	@Override
	public List<Product> findByNameLike(String Name) {
		Query q=em.createQuery("select p from Product as p where p.name like :n");
		q.setParameter("n", "%"+Name+"%");
	    return q.getResultList();
	}

}
