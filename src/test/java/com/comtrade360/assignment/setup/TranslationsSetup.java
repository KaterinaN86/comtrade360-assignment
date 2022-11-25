package com.comtrade360.assignment.setup;

import com.comtrade360.assignment.data.Translation;

import java.util.ArrayList;
import java.util.List;

public class TranslationsSetup {
    private List<Translation> translationList = new ArrayList<Translation>();
    private String originalMessage;

    private Translation testTranslation;

    public TranslationsSetup() {
        this.translationList = translationList;
        originalMessage = "Hello World!";
        translationList.add(new Translation(1, "mk", originalMessage, "Здраво Свету!"));
        translationList.add(new Translation(2, "el", originalMessage, "γεια σου κόσμε!"));
        translationList.add(new Translation(3, "sr", originalMessage, "Здраво Свете!"));
        translationList.add(new Translation(4, "sl", originalMessage, "Živjo Svet!"));
        translationList.add(new Translation(5, "fr", originalMessage, "Bonjour le monde!"));
        translationList.add(new Translation(6, "es", originalMessage, "Hola Mundo!"));
        translationList.add(new Translation(7, "it", originalMessage, "Ciao Mondo!"));
        translationList.add(new Translation(8, "hi", originalMessage, "हैलो वर्ल्ड"));
        translationList.add(new Translation(9, "bg", originalMessage, "Здравей свят!"));
        translationList.add(new Translation(10, "de", originalMessage, "Hallo Welt!"));
        testTranslation = new Translation(11, "no", originalMessage, "Hallo verden!");
    }

    public List<Translation> getTranslationList() {
        return translationList;
    }

    public void setTranslationList(List<Translation> translationList) {
        this.translationList = translationList;
    }

    public String getOriginalMessage() {
        return originalMessage;
    }

    public void setOriginalMessage(String originalMessage) {
        this.originalMessage = originalMessage;
    }

    public Translation getTestTranslation() {
        return testTranslation;
    }
}
