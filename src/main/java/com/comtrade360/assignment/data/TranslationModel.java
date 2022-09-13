package com.comtrade360.assignment.data;

/**
 * Simple class for model implementation of user input
 */
public class TranslationModel {

    //private fields
    private String language;
    private String translatedMessage;

    /**
     * Empty constructor
     */
    public TranslationModel() {
    }

    /**
     * Constructor
     *
     * @param language
     * @param translatedMessage
     */
    public TranslationModel(String language, String translatedMessage) {
        this.language = language;
        this.translatedMessage = translatedMessage;
    }

    // getters and setters
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTranslatedMessage() {
        return translatedMessage;
    }

    public void setTranslatedMessage(String translatedMessage) {
        this.translatedMessage = translatedMessage;
    }

    /**
     * Overriding toString method for better display of values for class fields
     *
     * @return
     */
    @Override
    public String toString() {
        return "TranslationModel{" +
                "language='" + language + '\'' +
                ", translatedMessage='" + translatedMessage + '\'' +
                '}';
    }
}
