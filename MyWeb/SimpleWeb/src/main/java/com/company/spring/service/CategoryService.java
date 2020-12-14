package com.company.spring.service;

import java.util.List;
import com.company.spring.entity.Category;

public interface CategoryService {

  List<Category> findAll();

  void addCategory(Category category);

  Category getById(int id);

  void deleteById(int id);

  void update(Category category);
}
