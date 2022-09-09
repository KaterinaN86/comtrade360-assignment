package com.comtrade360.assignment.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "translation")
public class Translation {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="language")
    private String language;
    @Column(name="original_message")
    private String originalMessage;
    @Column(name="translated_message")
    private String translatedMessage;

    public Translation() {
    }

    public Translation(Integer id, String language, String originalMessage, String translatedMessage) {
        this.id = id;
        this.language = language;
        this.originalMessage = originalMessage;
        this.translatedMessage = translatedMessage;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Translation that = (Translation) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

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
