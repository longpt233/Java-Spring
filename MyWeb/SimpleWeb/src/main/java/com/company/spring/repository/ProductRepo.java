package com.company.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.spring.entity.Product;

@Repository
@Transactional
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
