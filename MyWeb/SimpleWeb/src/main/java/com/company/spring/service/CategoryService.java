package com.company.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.spring.entity.Category;

@Service
@Transactional
public interface CategoryService {

	List<Category> findAll();
	void addCategory(Category category);
	Category getById(int id);
	void deleteById(int id);
	void update(Category category);
}
