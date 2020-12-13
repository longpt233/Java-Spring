package com.company.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.spring.entity.Product;


@Service
public interface ProductService {

	
	List<Product> findAll();
	
}
