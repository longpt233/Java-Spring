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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.spring.entity.Category;
import com.company.spring.entity.Product;
import com.company.spring.service.CategoryService;
import com.company.spring.service.ProductService;
import com.company.spring.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductService productService;

	@GetMapping("/home")
	public String home() {
		return "admin/home";
	}

	@GetMapping("/product")
	public String findPaginated(@RequestParam(name = "page", required = false, defaultValue = "1") Integer pageNo,
			Model model) {
		int pageSize = 2;

		Page<Product> page = productService.findPaginated(pageNo, pageSize);
		List<Product> listPage = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
//		System.out.println("test"+page.getTotalPages()+page.getTotalElements());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("list", listPage);
		return "admin/product";
	}

	@RequestMapping(value = "/product/add/save")
	public String saveFormAdd(@ModelAttribute("product") Product product) {
		System.out.println(" vao test save product");
		productService.addProduct(product);
		return "redirect:/admin/product?page=1";
	}

	// phai truyen vao ham nay mot doi tuong product cho no len dc html
	@RequestMapping("/product/add")
	public String showFormAdd(Product product,Category category) {
		return "admin/new_product";
	}

	@GetMapping("product/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "admin/update_product";
    }

	@PostMapping("product/update/{id}")
	public String updateStudent(@PathVariable("id") int id, @Valid Product product,
			Model model) {

		productService.update(product);
		return "admin/home";
	}

	@GetMapping("product/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id, Model model) {
        productService.deleteById(id);
        return "redirect:/admin/product";
    }
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/category")
	public String findPaginatedCate(Model model) {
		
		List<Category> listCate = categoryService.findAll();

		model.addAttribute("listCate", listCate);
		return "admin/category";
	}

	@RequestMapping(value = "/category/add/save")
	public String saveFormAddCate(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/category";
	}

	@GetMapping("/category/add")
	public String showFormAddCate(Category category) {
		return "admin/new_category";
	}


	@GetMapping("category/delete/{id}")
    public String deleteCate(@PathVariable("id") int id, Model model) {
        categoryService.deleteById(id);
        return "redirect:/admin/category";
    }

}
