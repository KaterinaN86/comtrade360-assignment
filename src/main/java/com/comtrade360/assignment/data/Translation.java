package com.comtrade360.assignment.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//mapping the model to our database

/**
 * Entity class for translation model
 */
@Entity(name = "translation")
public class Translation {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "language")
    private String language;
    @Column(name = "original_message")
    private String originalMessage;
    @Column(name = "translated_message")
    private String translatedMessage;

    //empty constructor is necessary for JPA

    /**
     * Empty constructor
     */
    public Translation() {
    }

    /**
     * Constructor
     *
     * @param id
     * @param language
     * @param originalMessage
     * @param translatedMessage
     */
    public Translation(Integer id, String language, String originalMessage, String translatedMessage) {
        this.id = id;
        this.language = language;
        this.originalMessage = originalMessage;
        this.translatedMessage = translatedMessage;
    }

    //Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOriginalMessage() {
        return originalMessage;
    }

    public void setOriginalMessage(String originalMessage) {
        this.originalMessage = originalMessage;
    }

    public String getTranslatedMessage() {
        return translatedMessage;
    }

    public void setTranslatedMessage(String translatedMessage) {
        this.translatedMessage = translatedMessage;
    }

    /**
     * Overriding equals method in Object to prevent memory leakage
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Translation that = (Translation) o;
        return id != null ? id.equals(that.id) : that.id == null;
    }

    /**
     * Overriding hashCode method in Object to prevent memory leakage
     *
     * @return
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    /**
     * Overriding toString method for better display of values for class fields
     *
     * @return
     */
    @Override
    public String toString() {
        return "Translation{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", originalMessage='" + originalMessage + '\'' +
                ", translatedMessage='" + translatedMessage + '\'' +
                '}';
    }
}
