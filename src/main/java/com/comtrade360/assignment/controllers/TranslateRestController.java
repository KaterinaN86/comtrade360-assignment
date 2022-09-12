package com.comtrade360.assignment.controllers;

import com.comtrade360.assignment.services.JPATranslationService;
import com.comtrade360.assignment.services.TranslationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class TranslateRestController {

    @Autowired
    JPATranslationService translationService;
    public TranslateRestController(JPATranslationService translationService) {

        this.translationService = translationService;
    }

//    @Autowired
//    TranslationServiceImpl translationService;
//
//    public TranslateRestController(TranslationServiceImpl translationService) {
//
//       this.translationService = translationService;
//   }

     @GetMapping("/hello-rest")
    public String helloWorld(){
        return "Hello World";
    }

    //translating by language
    @GetMapping("/translate")
    public  String translate(@RequestParam(name="language", defaultValue = "en") String language){

        return translationService.getTranslation(language, "Hello World");
    }


}
