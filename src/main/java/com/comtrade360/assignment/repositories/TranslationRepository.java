package com.comtrade360.assignment.repositories;


import com.comtrade360.assignment.data.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//creating repository interface responsible for persisting application logging data into the database
@Repository
public interface TranslationRepository extends JpaRepository<Translation, Integer> {

    Translation findByLanguageAndOriginalMessage(String language, String originalMessage);


}
