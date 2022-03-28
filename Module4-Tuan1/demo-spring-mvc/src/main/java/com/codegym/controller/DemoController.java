package com.codegym.controller;

import com.codegym.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
    @RequestMapping("demo")
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView("demo");
        String name = "CodeGym";
        modelAndView.addObject("name", name);
        Customer customer = new Customer(1, "CodeGym Hà Nội");
        modelAndView.addObject("cust", customer);
        return modelAndView;
    }
}
