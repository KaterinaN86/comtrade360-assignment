package com.comtrade360.assignment.services;

import com.comtrade360.assignment.data.Translation;
import com.comtrade360.assignment.repositories.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Implementation of business logic for getting translation from a database

@Service
//implementation will be applied for any active profile that is NOT "api"
@Profile("!api")
public class JPATranslationService implements TranslationService{

    @Autowired
    private TranslationRepository translationRepository;

    //getters and setters

    public TranslationRepository getTranslationRepository() {
        return translationRepository;
    }

    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    //implementing getTranslation method from TranslationService interface
    @Override
    public String getTranslation(String language, String originalMessage) {

        //creating model instance
        Translation translation =
                translationRepository.findByLanguageAndOriginalMessage(language, originalMessage);

        //if request is successfully resolved
        if(translation!=null){

            //we return translated message
            return translation.getTranslatedMessage();
        }
        //if request failed we return original message that didn't get translated
        return  originalMessage;
    }

    @Override
    public void addTranslation(Translation translation) {
        //saving the instance
        translationRepository.save(translation);
    }

    @Override
     public Optional<Translation> findById(int id){

        return translationRepository.findById(id);
    }

    @Override
    public int countTranslations() {
        return (int) translationRepository.count();
    }

    @Override
    public List<Translation> getAll() {
        return translationRepository.findAll();
    }


}