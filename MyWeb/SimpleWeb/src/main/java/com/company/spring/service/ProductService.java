package com.company.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.company.spring.entity.Product;


@Service
public interface ProductService {

	
	List<Product> findAll();
	void addProduct(Product product);
	Product getById(long id);
	void deleteById(long id);
	Page<Product> findPaginated(int pageNo, int pageSize);
	
}
