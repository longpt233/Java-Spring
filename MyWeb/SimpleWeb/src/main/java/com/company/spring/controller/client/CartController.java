package com.company.spring.controller.client;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

  @RequestMapping("/cart")
  public ModelAndView listEmployee(ModelAndView model) throws IOException {
    model.setViewName("client/cart");
    return model;
  }
  
  @RequestMapping("/checkout")
  public ModelAndView checkOut(ModelAndView model) throws IOException {
    model.setViewName("client/checkout");
    return model;
  }

}
