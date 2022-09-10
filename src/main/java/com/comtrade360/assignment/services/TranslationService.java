package com.comtrade360.assignment.services;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

public interface TranslationService {

    String getTranslation(String language, String originalMessage);

}
