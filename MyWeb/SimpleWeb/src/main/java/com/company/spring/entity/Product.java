package com.company.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

  public Product() {}

  public Product(int id, String product_name, String description, String product_image, int price,
      int quantity, Category category) {
    super();
    this.id = id;
    this.product_name = product_name;
    this.description = description;
    this.product_image = product_image;
    this.price = price;
    this.quantity = quantity;
    this.category = category;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String product_name;

  @Column
  private String description;

  @Column
  private String product_image;

  @Column
  private int price;

  @Column
  private int quantity;

  @ManyToOne
  @JoinColumn(name = "id_category")
  private Category category;

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProduct_name() {
    return product_name;
  }

  public void setProduct_name(String product_name) {
    this.product_name = product_name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getProduct_image() {
    return product_image;
  }

  public void setProduct_image(String product_image) {
    this.product_image = product_image;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", product_name=" + product_name + ", description=" + description
        + ", product_image=" + product_image + ", price=" + price + ", quantity=" + quantity
        + ", category=" + category + ", categoryId=" + category + "]";
  }



}
