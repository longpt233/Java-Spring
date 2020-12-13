package com.company.spring.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.spring.entity.Product;
import com.company.spring.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductServiceImpl productService;

	@GetMapping("/home")
	public String home() {
		return "admin/home";
	}

	@GetMapping("/products")
	public String product(Model model) {
		List<Product> listProduct = productService.findAll();
		model.addAttribute("list", listProduct);
		return "admin/product";
	}

}
