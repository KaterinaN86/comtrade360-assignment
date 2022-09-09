package com.comtrade360.assignment.repositories;


import com.comtrade360.assignment.data.Translation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationRepository extends CrudRepository<Translation, Integer> {

    Translation findByLanguageAndOriginalMessage(String language, String originalMessage);

}
