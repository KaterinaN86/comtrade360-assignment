package com.comtrade360.assignment.controllers;

import com.comtrade360.assignment.services.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//hods API resources, like endpoints
//communicates with Service layer that holds business logic

@RestController
public class TranslateRestController {

    @Autowired
    TranslationService translationService;

    //initializing the interface bean. With this we enable different implementations of the interface
    //depending on the active profile
    public TranslateRestController(TranslationService translationService) {

        this.translationService = translationService;
    }

     @GetMapping("/hello-rest")
    public String helloWorld(){
        return "Hello World";
    }

    /**
     * translating original message "Hello World" by language
     * @param language (String with language ISO code)
     * @return (String with translated message)
     */
    @GetMapping("/translate")
    public  String translate(@RequestParam(name="language", defaultValue = "en") String language){

        return translationService.getTranslation(language, "Hello World");
    }


}
