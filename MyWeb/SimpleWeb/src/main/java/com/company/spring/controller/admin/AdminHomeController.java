package com.company.spring.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

  @GetMapping("/home")
  public String home() {
    return "admin/home";
  }
//GET: Show Login Page
  @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
  public String login(Model model) {

     return "admin/login";
  }

}
