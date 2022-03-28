package com.codegym.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeCotroller {
    @GetMapping("/")
    public String showIndex() {
        return "/index";
    }

}
