package com.rakuten.training.dal;

import org.springframework.data.repository.CrudRepository;

import com.rakuten.training.domain.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {

}

//There are bunch of methods in CrudRepository but we can also implement our own here following the naming convention
