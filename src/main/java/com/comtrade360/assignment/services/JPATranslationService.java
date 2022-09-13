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
/**
 * Implementation of TranslationService interface methods by using database operations
 */
public class JPATranslationService implements TranslationService {

    /**
     * Dependency injection for TranslationRepository bean
     */
    @Autowired
    private TranslationRepository translationRepository;

    //getters and setters
    public TranslationRepository getTranslationRepository() {
        return translationRepository;
    }

    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    /**
     * Implementing getTranslation method from TranslationService interface
     *
     * @param language        (String made up of the ISO code for a certain language
     * @param originalMessage (String with the text to be translated)
     * @return String translated message or original message if no translation is found
     */
    @Override
    public String getTranslation(String language, String originalMessage) {

        //creating model instance
        Translation translation =
                translationRepository.findByLanguageAndOriginalMessage(language, originalMessage);

        //if request is successfully resolved
        if (translation != null) {

            //we return translated message
            return translation.getTranslatedMessage();
        }
        //if request failed we return original message that didn't get translated
        return originalMessage;
    }

    /**
     * Implementing method for adding translation
     *
     * @param translation (Translation object)
     */
    @Override
    public void addTranslation(Translation translation) {
        //saving the instance
        translationRepository.save(translation);
    }

    /**
     * Implementing method that returns a translation object that matches the id passed as a parameter
     *
     * @param id (int representing the id of the entity we want to find)
     * @return Translation object or null
     */
    @Override
    public Optional<Translation> findById(int id) {

        return translationRepository.findById(id);
    }

    /**
     * Implements method that counts the translations in our table
     *
     * @return number of entries in our table
     */
    @Override
    public int countTranslations() {
        return (int) translationRepository.count();
    }

    /**
     * Implements method that returns a list of all translations
     *
     * @return list of all translation objects
     */
    @Override
    public List<Translation> getAll() {
        return translationRepository.findAll();
    }


}