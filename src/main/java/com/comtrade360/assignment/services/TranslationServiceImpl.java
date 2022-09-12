package com.comtrade360.assignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Service
public class TranslationServiceImpl implements TranslationService{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${external.translate.api.url}")
private String translateAPIBaseURL;

    @Override
    public String getTranslation(String language, String originalMessage) {

        String translation =
                restTemplate.getForObject(translateAPIBaseURL+"?q="
                        + originalMessage+"&source=en&target="+language, String.class);

        if(translation!=null){

            return translation;
        }

        return  originalMessage;
    }
}
