package com.comtrade360.assignment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //handler method
    @GetMapping("/hello-rest")
    public String helloWorld(){
        return "Hello World";
    }


}
