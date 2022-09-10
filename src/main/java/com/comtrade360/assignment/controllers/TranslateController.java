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

    @Autowired
    private final TranslationService translationService;
    @Autowired
    private final TranslationRepository translationRepository;

    public TranslateController(TranslationService translationService, TranslationRepository translationRepository) {
        this.translationService = translationService;
        this.translationRepository = translationRepository;
    }
    
    @RequestMapping(value="/translate/all")
    public String getAllTranslations(Model model){

        model.addAttribute("translations", translationRepository.findAll());

        return "translations/list";
    }

    @GetMapping (value="/translate/add")
    public String insertTranslation(Model model){

        TranslationModel translationModel = new TranslationModel();

        model.addAttribute("translationModel",translationModel);
        return "translations/insert";
    }

    @PostMapping(value="/translate/save")
    public String submitTranslation(@ModelAttribute ("translationModel") TranslationModel translationModel)
    {
        //the new id will be equal to the number of data entries already in the database + 1
        int newId = (int) translationRepository.count()+1;
        //checking for existing entities with same key
        if(translationRepository.findById(newId).isPresent())
            translationRepository.deleteById(newId);
        //using the model object (from user input) to create an instance from the model that will be saved in database
        Translation translation = new Translation(newId, translationModel.getLanguage(),
                "Hello World", translationModel.getTranslatedMessage());
        //saving the instance
        translationRepository.save(translation);

        return "translations/insert_success";
    }


}