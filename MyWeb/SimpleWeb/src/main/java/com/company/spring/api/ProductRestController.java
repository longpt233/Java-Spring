package com.company.spring.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.spring.entity.Product;
import com.company.spring.request.ProductRequest;
import com.company.spring.response.BeanResponse;
import com.company.spring.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {

  @Autowired
  private ProductService productService;

  @GetMapping("/products")
  List<Product> findAll() {
    return productService.findAll();
  }
  
  @PostMapping("/products/{id}")
  BeanResponse add(@RequestBody ProductRequest productRequest) {
    
    
    
    return productService.updateAPI(productRequest);
  }

}
