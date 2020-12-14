package com.company.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	@Override
	public void addProduct(Product product) {
		productRepo.save(product);
		
	}

	@Override
	public Product getById(int id) {
		return productRepo.getOne(id);
		 
	}

	@Override
	public void deleteById(int id) {
		productRepo.deleteById(id);
	}

	@Override
	public Page<Product> findPaginated(int pageNo, int pageSize){

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return  productRepo.findAll(pageable);
	}

	@Override
	public void update(Product product) {
		productRepo.save(product);
		
	}

}
