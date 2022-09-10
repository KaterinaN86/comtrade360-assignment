package com.comtrade360.assignment.services;

import com.comtrade360.assignment.data.Translation;
import com.comtrade360.assignment.repositories.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Service
public class JPATranslationService implements TranslationService{

    @Autowired
    private TranslationRepository translationRepository;

    public TranslationRepository getTranslationRepository() {
        return translationRepository;
    }

    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    @Override
    public String getTranslation(String language, String originalMessage) {

        Translation translation = translationRepository.findByLanguageAndOriginalMessage(language, originalMessage);

        if(translation!=null){

            return translation.getTranslatedMessage();
        }

        return  originalMessage;
    }
}