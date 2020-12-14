package com.company.spring.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.company.spring.entity.Product;
import com.company.spring.request.ProductRequest;
import com.company.spring.response.BeanResponse;

public interface ProductService {

  List<Product> findAll();

  void addProduct(Product product);

  Product getById(int id);

  void deleteById(int id);

  Page<Product> findPaginated(int pageNo, int pageSize);

  void update(Product product);
  
  BeanResponse updateAPI(ProductRequest product);

}
