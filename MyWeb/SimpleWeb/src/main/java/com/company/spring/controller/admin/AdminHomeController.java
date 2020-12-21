package com.company.spring.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminHomeController {

  @RequestMapping("/admin/home")
  public String home() {
    return "admin/home";
  }
//GET: Show Login Page
  @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
  public String login(Model model) {

     return "admin/login";
  }
  
  @RequestMapping("/403")
  public String accessDenied() {
    return "403";
  }

}
