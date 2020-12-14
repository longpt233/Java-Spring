package com.company.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.spring.entity.Category;
import com.company.spring.repository.CategoryRepo;
import com.company.spring.service.CategoryService;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	@Override
	public void addCategory(Category category) {
		categoryRepo.save(category);
		
	}

	@Override
	public Category getById(int id) {
		// TODO Auto-generated method stub
		return categoryRepo.getOne(id);
	}

	@Override
	public void deleteById(int id) {
		categoryRepo.deleteById(id);
		
	}

	@Override
	public void update(Category category) {
		categoryRepo.save(category);
		
	}

}
