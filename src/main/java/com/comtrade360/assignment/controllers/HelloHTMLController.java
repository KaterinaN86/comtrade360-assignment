package com.comtrade360.assignment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Simple controller with method that requires user login
 */
@Controller
public class HelloHTMLController {

    /**
     * Handles secured hello endpoint
     * @return (shows thymeleaf template)
     */
    @RequestMapping("/hello")
    public String getHelloHtml() {
        return "hello_world";
    }

}
