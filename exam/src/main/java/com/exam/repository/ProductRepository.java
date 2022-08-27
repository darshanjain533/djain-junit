package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exam.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByNameContaining(String name);
	List<Product> findByPrice(String price);
	
	@Query("Select u.name,u.price from Product u GROUP BY u.price")
	List<String> groupByPrice();
}
