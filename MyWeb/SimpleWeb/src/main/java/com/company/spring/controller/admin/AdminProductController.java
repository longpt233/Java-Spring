package com.company.spring.controller.admin;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.company.spring.entity.Product;
import com.company.spring.service.CategoryService;
import com.company.spring.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

  @Autowired
  private ProductService productService;
  
  @Autowired
  private CategoryService categoryService;

  @GetMapping("/product")
  public String findPaginated(
      @RequestParam(name = "page", required = false, defaultValue = "1") Integer pageNo,
      Model model) {
    int pageSize = 2;

    Page<Product> page = productService.findPaginated(pageNo, pageSize);
    List<Product> listPage = page.getContent();

    model.addAttribute("currentPage", pageNo);
    model.addAttribute("totalPages", page.getTotalPages());
    // System.out.println("test"+page.getTotalPages()+page.getTotalElements());
    model.addAttribute("totalItems", page.getTotalElements());

    model.addAttribute("list", listPage);
    return "admin/product/list";
  }

  @PostMapping(value = "/product/add")
  public String saveFormAdd(@ModelAttribute("product") Product product) {
    System.out.println(" vao test save product" + product.toString());
    productService.addProduct(product);
    return "redirect:/admin/product?page=1";
  }

  // phai truyen vao ham nay mot doi tuong product cho no len dc html
  @GetMapping("/product/add")
  public String showFormAdd(Model model, Product product) {
    // model.addAttribute("product",product );
    model.addAttribute("category", categoryService.findAll());


    return "admin/product/add";
  }

  @GetMapping("product/edit/{id}")
  public String showUpdateForm(@PathVariable("id") int id, Model model) {
    Product product = productService.getById(id);
    model.addAttribute("product", product);
    model.addAttribute("category", categoryService.findAll());
    return "admin/product/update";
  }

  @PostMapping("product/edit/{id}")
  public String updateStudent(@PathVariable("id") int id, @Valid Product product, Model model) {

    productService.update(product);
    return "admin/home";
  }

  @GetMapping("product/delete/{id}")
  public String deleteStudent(@PathVariable("id") int id, Model model) {
    productService.deleteById(id);
    return "redirect:/admin/product";
  }
}
