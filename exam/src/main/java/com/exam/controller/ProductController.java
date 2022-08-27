package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Product;
import com.exam.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/getname")
	public List<Product> getNamedetails(@RequestParam String name) {
		return service.getServNameDetails(name);
	}
	
	@GetMapping("/getprice")
	public List<Product> getPricedetails(@RequestParam String price) {
		return service.getServPriceDetails(price);
	}
	
	@GetMapping("/getall")
	public List<Product> getAlldetails(@RequestParam String price) {
		return service.getServDetails(price);
	}
}
