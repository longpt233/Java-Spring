package com.company.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.spring.entity.Category;

@Repository
@Transactional
public interface CategoryRepo extends JpaRepository<Category,Integer>{

//	@Autowired
//	private SessionFactory sessionFactory;
// binh thuong se can 2 cai nay xong viet query cho no 
}
