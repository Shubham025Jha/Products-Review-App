package com.rakuten.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Reviews;

@Repository
@Transactional
public class ReviewDAOInJPAImp implements ReviewDAO {
	
	@Autowired
	EntityManager em;

	@Override
	public Reviews save(Reviews toBeSaved) {
		
		em.persist(toBeSaved);
		
		return toBeSaved;
	}

	@Override
	public List<Reviews> findAll() {
		Query q=em.createQuery("Select q from Reviews as q");
		return q.getResultList();
	}

	@Override
	public Reviews findById(int id) {
		
		return em.find(Reviews.class, id);
	}

	@Override
	public void deleteById(int id) {
		Reviews r= findById(id);
		if(r!= null)
			em.remove(r);
		else
			System.out.println("Entry not found to delete....");
	}

	@Override
	public List<Reviews> findByRatingGreaterThan(int rating) {
		Query q=em.createQuery("select r from Reviews as r where r.rating>:rate");
		q.setParameter("rate", rating);
		return q.getResultList();
	}

	@Override
	public List<Reviews> findByPid(Product p) {
		Query q=em.createQuery("select r from Reviews as r where r.pro=:p");
		q.setParameter("p", p);
		return q.getResultList();
	}

}
