package com.company.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.spring.entity.Product;
import com.company.spring.repository.ProductRepo;
import com.company.spring.service.ProductService;


@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo productRepo;

	public List<Product> findAll() {
		return productRepo.findAll();
	}

}
