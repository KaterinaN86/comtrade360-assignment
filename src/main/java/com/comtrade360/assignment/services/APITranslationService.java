package com.comtrade360.assignment.services;

import com.comtrade360.assignment.data.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

//Implementation of business logic for getting translation from external API (Google Translate)

@Service
//implementation will be applied if active profile is "api"
@Profile("api")
public class APITranslationService implements TranslationService{

    @Autowired
    private RestTemplate restTemplate;

    //value of api URL, @Value("${external.translate.api.url}")
    @Value("${external.translate.api.url}")
    private String translateAPIBaseURL;

    //implementing getTranslation method from TranslationService interface
    @Override
    public String getTranslation(String language, String originalMessage) {

        //using restTemplate object
        String translation =
                restTemplate.getForObject(translateAPIBaseURL+"?q="
                        + originalMessage+"&source=en&target="+language, String.class);

        //if request is successfully resolved
        if(translation!=null){

            //we return the translated message
            return translation;
        }

        return  originalMessage;
    }

    @Override
    public void addTranslation(Translation translation) {

    }

    @Override
    public Optional<Translation> findById(int id) {
        return Optional.empty();
    }

    @Override
    public int countTranslations() {
        return 0;
    }

    @Override
    public List<Translation> getAll() {
        return null;
    }
}
