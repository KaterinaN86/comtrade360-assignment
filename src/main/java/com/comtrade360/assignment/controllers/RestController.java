package com.comtrade360.assignment.controllers;

import com.comtrade360.assignment.services.JPATranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    JPATranslationService translationService;

    public RestController(JPATranslationService translationService) {
        this.translationService = translationService;
    }

    //handler method
    @GetMapping("/hello-rest")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/translate")
    public  String translate(@RequestParam(name="language", defaultValue = "en") String language){


        return translationService.getTranslation(language, "Hello World");
    }


}
