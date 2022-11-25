package com.comtrade360.assignment.services;


import com.comtrade360.assignment.data.Translation;
import com.comtrade360.assignment.repositories.TranslationRepository;
import com.comtrade360.assignment.setup.TranslationsSetup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class JPATranslationServiceTest {
    /**
     * initializing logger object
     */
    static final Logger log = Logger.getLogger(JPATranslationService.class.getName());
    /**
     * List of translations for "Hello World!" message in 10 different languages
     */
    List<Translation> translationList;
    /**
     * Mock object for TranslationRepository
     */
    @Mock
    private TranslationRepository translationRepository;
    /**
     * Initializing jpaTranslationService object using predefined mock object
     */
    @InjectMocks
    JPATranslationService jpaTranslationService = new JPATranslationService(translationRepository);
    /**
     * Object used to set up data for testing
     */
    TranslationsSetup translationsSetup;

    /**
     * Method called before tests start to execute
     *
     * @throws Exception
     */
    @BeforeAll
    static void setUp() throws Exception {
        log.info("Started testing JPATranslationService class\n");
    }

    /**
     * Method called before each test, sets up data for testing
     */
    @BeforeEach
    public void setUpTestData() {
        //initializing TranslationSetup object that sets up data for testing
        translationsSetup = new TranslationsSetup();
        //initializing list of translations to be tested
        translationList = translationsSetup.getTranslationList();
    }

    @Test
    public void shouldReturnOriginalMessageForLanguageCodeHR() {
        log.info("Testing if original message is returned when translated message is not found for specified language.\n");
        //initializing language to ISO code which is not a part of any translation object in specified list
        String language = "hr";
        String originalMessage = translationsSetup.getOriginalMessage();
        assertEquals(originalMessage, jpaTranslationService.getTranslation(language, originalMessage));
        log.info("Returned value from method getTranslation matches original message. End of test.\n");
    }

    @Test
    public void JPATranslationServiceConstructorShouldInitializeTranslationRepository() {
        log.info("Testing if translateRepository object is initialized when JPATranslationService object is initialized using constructor.\n");
        JPATranslationService jpaTranslationService = new JPATranslationService(translationRepository);
        assertEquals(translationRepository, jpaTranslationService.getTranslationRepository());
        log.info("TranslationRepository object is successfully instantiated. End of test\n");
    }

    @Test
    public void findByIdShouldRerurnEmptyInstanceOfOptionalForInvalidId() {
        log.info("Testing if empty Optional object is returned when findById method is called for id 11.\n");
        assertEquals(Optional.empty(), jpaTranslationService.findById(11));
        log.info("Returned result matches expected. End of test.\n");
    }

    @Test
    public void verifyAddTranslationServiceMethodCallsTranslationRepositorySaveMethod() {
        log.info("Testing if call to addTranslation method in JPATranslationService results in a call to save method in TranslationRepository.\n");
        //Initializing Translation object
        Translation testTranslation = translationsSetup.getTestTranslation();
        //using Mockito to define return value for save method
        //when(translationRepository.save(any(Translation.class))).thenReturn(testTranslation);
        jpaTranslationService.addTranslation(testTranslation);
        verify(translationRepository, times(1)).save(testTranslation);
        log.info("Verified call to specified method. End of test.\n");
    }

    @Test
    void getAll() throws Exception {
        when(translationRepository.findAll()).thenReturn(translationList);
        /**
         * getting the data
         */
        List<Translation> translations = jpaTranslationService.getAll();

        /**
         * check that getAll returns an object
         */
        assertEquals(translationList.size(), 10);

        /**
         * verify getAll was called once
         */
        verify(translationRepository, times(1)).findAll();
    }
}