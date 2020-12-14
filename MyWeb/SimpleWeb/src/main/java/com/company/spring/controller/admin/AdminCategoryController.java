package com.company.spring.controller.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.company.spring.entity.Category;
import com.company.spring.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class AdminCategoryController {
  
  @Autowired
  private CategoryService categoryService;

  @GetMapping("/category")
  public String findPaginatedCate(Model model) {

    List<Category> listCate = categoryService.findAll();

    model.addAttribute("listCate", listCate);
    return "admin/category/list";
  }

  @RequestMapping(value = "/category/add/save")
  public String saveFormAddCate(@ModelAttribute("category") Category category) {
    categoryService.addCategory(category);
    return "redirect:/admin/category";
  }

  @GetMapping("/category/add")
  public String showFormAddCate(Category category) {
    return "admin/category/add";
  }


  @GetMapping("category/delete/{id}")
  public String deleteCate(@PathVariable("id") int id, Model model) {
    categoryService.deleteById(id);
    return "redirect:/admin/category";
  }
}
