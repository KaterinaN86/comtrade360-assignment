package com.comtrade360.assignment.controllers;



import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloHTMLController {

    @RequestMapping("/hello")
    public String insertTranslation(){
        return "hello_world";
    }

}
