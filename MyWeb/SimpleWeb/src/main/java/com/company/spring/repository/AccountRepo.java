package com.company.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.spring.entity.Account;

public interface AccountRepo extends JpaRepository<Account,String> {

	
	@Query(value = "SELECT * FROM accounts " +
            "WHERE USER_NAME = :nameParam  " ,nativeQuery = true)
    Account findByName(@Param("nameParam") String name);
}
