package com.exam.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exam.model.Product;
import com.exam.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired 
	ProductRepository repo;
	
	public List<Product> getServNameDetails(String name) {
		// TODO Auto-generated method stub
		List<Product> prod = repo.findByNameContaining(name);
		
		return prod;
	}

	public List<Product> getServPriceDetails(String price) {
		// TODO Auto-generated method stub
		List<Product> prod = repo.findByPrice(price);
		return prod;
	}
	
	public List<Product> getServDetails(String price) {
		// TODO Auto-generated method stub
		Predicate<Product> pred = pr -> Integer.parseInt(pr.getPrice()) > Integer.parseInt(price);
		List<Product> prod = repo.findAll().stream().filter(pred).collect(Collectors.toList());		
		
		return prod;
	}

	public List<String> getAllPrice() {

		return repo.groupByPrice();
	}

}
