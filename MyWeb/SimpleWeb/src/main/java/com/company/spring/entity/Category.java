package com.company.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	
	
	 public Category() {
	}

	public Category(int id, String name, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @Column(name = "name", length = 45)
	 private String name;
	 
	 @OneToMany(mappedBy = "category")
	 private List<Product> products = new ArrayList<Product>();
	 // no join voi bang nao la phu thuoc vao Class Product

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	 
	 
	 
}
