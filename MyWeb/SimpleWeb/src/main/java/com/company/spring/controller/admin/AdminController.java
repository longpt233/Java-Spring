package com.company.spring.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.spring.entity.Product;
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

//	@GetMapping("/products")
//	public String product(Model model) {
//		List<Product> listProduct = productService.findAll();
//		model.addAttribute("list", listProduct);
//		return "admin/product";
//	}
	
	@GetMapping("/products")
	public String findPaginated(@RequestParam(name = "page", required = false, defaultValue = "1") Integer pageNo,
			Model model) {
		int pageSize = 1;
		
		Page<Product> page = productService.findPaginated(pageNo, pageSize);
		List<Product> list = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		System.out.println("test"+page.getTotalPages()+page.getTotalElements());
		model.addAttribute("totalItems", page.getTotalElements());
		
		
		model.addAttribute("list", list);
		return "admin/product";
	}
	
	@GetMapping("/add")
	public String showFormAdd() {
		return "admin/new_product";
	}
	
	@GetMapping("/add/save")
	public String saveFormAdd(@ModelAttribute("product") Product product) {
		return "admin/new_product";
	}

}
