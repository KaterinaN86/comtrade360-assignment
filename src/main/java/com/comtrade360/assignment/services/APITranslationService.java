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
/**
 * Implementation of TranslationService interface methods by using external API for translation
 */
public class APITranslationService implements TranslationService {

    //dependency injection for restTemplate object
    @Autowired
    private RestTemplate restTemplate;
    //value of api URL, @Value("${external.translate.api.url}")
    @Value("${external.translate.api.url}")
    private String translateAPIBaseURL;

    /**
     * Implementing getTranslation method from TranslationService interface
     *
     * @param language        (String made up of the ISO code for a certain language
     * @param originalMessage (String with the text to be translated)
     * @return
     */
    @Override
    public String getTranslation(String language, String originalMessage) {

        //using restTemplate object
        String translation =
                restTemplate.getForObject(translateAPIBaseURL + "?q="
                        + originalMessage + "&source=en&target=" + language, String.class);

        //if request is successfully resolved
        if (translation != null) {
            //we return the translated message
            return translation;
        }
        return originalMessage;
    }

    /**
     * Empty implementation for interface method
     *
     * @param translation (Translation object)
     */
    @Override
    public void addTranslation(Translation translation) {
    }

    /**
     * Implementing interface method
     *
     * @param id (int representing the id of the entity we want to find)
     * @return (Translation object or null)
     */
    @Override
    public Optional<Translation> findById(int id) {
        return Optional.empty();
    }

    /**
     * Empty implementation for interface method
     *
     * @return
     */
    @Override
    public int countTranslations() {
        return 0;
    }

    /**
     * Empty implementation for interface method
     *
     * @return
     */
    @Override
    public List<Translation> getAll() {
        return null;
    }
}