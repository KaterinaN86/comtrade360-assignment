package com.comtrade360.assignment.controllers;

import com.comtrade360.assignment.data.Translation;
import com.comtrade360.assignment.repositories.TranslationRepository;
import com.comtrade360.assignment.services.JPATranslationService;
import com.comtrade360.assignment.services.TranslationService;
import com.comtrade360.assignment.setup.TranslationsSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TranslateRestControllerTest {
    static final Logger log = Logger.getLogger(TranslateRestControllerTest.class.getName());
    List<Translation> translationList;
    TranslationsSetup translationsSetup;
    @Mock
    private JPATranslationService translationService;
    @InjectMocks
     TranslateRestController translateRestController = new TranslateRestController(translationService);

    @BeforeEach
    void setUp() {
        translationsSetup = new TranslationsSetup();
        translationList = translationsSetup.getTranslationList();
        when(translationService.getTranslation(any(String.class),any(String.class))).thenReturn("Hello World!");
    }


    @AfterEach
    void tearDown() {
    }
}