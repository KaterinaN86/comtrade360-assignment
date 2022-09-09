package com.comtrade360.assignment.data;

public class TranslationModel {

    private String language;
    private String translatedMessage;

    public TranslationModel() {
    }

    public TranslationModel(String language, String translatedMessage) {
        this.language = language;
        this.translatedMessage = translatedMessage;
    }

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

    @Override
    public String toString() {
        return "TranslationModel{" +
                "language='" + language + '\'' +
                ", translatedMessage='" + translatedMessage + '\'' +
                '}';
    }
}
