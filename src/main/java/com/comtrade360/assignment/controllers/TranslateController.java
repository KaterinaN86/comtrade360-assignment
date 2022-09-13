package com.comtrade360.assignment.controllers;

import com.comtrade360.assignment.data.Translation;
import com.comtrade360.assignment.data.TranslationModel;
import com.comtrade360.assignment.repositories.TranslationRepository;
import com.comtrade360.assignment.services.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TranslateController {

    //dependency injection for bean TranslationService
    @Autowired
    private final TranslationService translationService;

    //constructor
    public TranslateController(TranslationService translationService) {
        this.translationService = translationService;
    }
    
    @RequestMapping(value="/translate/all")
    public String getAllTranslations(Model model){

        model.addAttribute("translations", translationService.getAll());

        return "translations/list";
    }

    @GetMapping (value="/translate/add")
    public String insertTranslation(Model model){

        //adds user input to our model
        TranslationModel translationModel = new TranslationModel();
        model.addAttribute("translationModel",translationModel);

        //shows Thymeleaf template
        return "translations/insert";
    }

    //passing the model for user data as a parameter and adding new translation entity to our database
    @PostMapping(value="/translate/save")
    public String submitTranslation(@ModelAttribute ("translationModel") TranslationModel translationModel)
    {
        //the new id will be equal to the number of data entries already in the database + 1
        int newId = translationService.countTranslations()+1;

        //checking for existing entities with same key
        while(translationService.findById(newId).isPresent()) {
            //while there is such entry, we increase the new id by one
            newId++;
        }
        //using the model object (from user input) to create an instance from the model that will be saved in database
        Translation translation = new Translation(newId, translationModel.getLanguage(),
                "Hello World", translationModel.getTranslatedMessage());

        //making a service all and passing the model instance
        translationService.addTranslation(translation);

        //showing Thymeleaf template
        return "translations/insert_success";
    }


}