package com.comtrade360.assignment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloHTMLController {

    @RequestMapping("/hello")
    public String insertTranslation(){
        return "hello_world";
    }

}
