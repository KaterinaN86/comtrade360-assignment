package com.comtrade360.assignment.services;


import com.comtrade360.assignment.data.Translation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

//Interface for implementing business logic

/**
 * Defines interface for creating translations and accessing translations.
 */
public interface TranslationService {
    /**
     * Takes the ISO code for a language and translates the original message
     * @param language (String made up of the ISO code for a certain language
     * @param originalMessage (String with the text to be translated)
     * @return (String wit translated text)
     */
    String getTranslation(String language, String originalMessage);

    /**
     * Adds new translation entity
      * @param translation (Translation object)
     */
    void addTranslation(Translation translation);

    /**
     * Searches for a translation with a certain id
     * @param id (int representing the id of the entity we want to find)
     * @return
     */
    Optional<Translation> findById(int id);
    int countTranslations();
    List<Translation> getAll();

}
