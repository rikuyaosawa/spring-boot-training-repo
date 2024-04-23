package com.ltp.globalsuperstore;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class Controller {
  @GetMapping("/")
  public String getForm(Model model) {
    model.addAttribute("categories", Constants.CATEGORIES);
    return "form";
  };
}
