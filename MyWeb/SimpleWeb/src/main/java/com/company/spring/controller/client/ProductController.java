package com.company.spring.controller.client;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

  @RequestMapping("/product")
  public ModelAndView listEmployee(ModelAndView model) throws IOException {
    model.setViewName("client/product");
    return model;
  }

}