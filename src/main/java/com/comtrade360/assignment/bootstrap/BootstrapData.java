package com.comtrade360.assignment.bootstrap;

import com.comtrade360.assignment.data.Translation;
import com.comtrade360.assignment.repositories.TranslationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    //dependency injection
    private final TranslationRepository translationRepository;

    public BootstrapData(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    Set<Translation> translations = new HashSet<>() ;

    translations.add(new Translation(1,"en","Hello World", "Helo World"));
    translations.add(new Translation(2,"mk","Hello World", "Здраво Свету"));
    translations.add(new Translation(3,"sr","Hello World", "Здраво Свете"));
    translations.add(new Translation(4,"hr","Hello World", "Pozdrav Svijete"));
    translations.add(new Translation(5,"bg","Hello World", "Здравей свят"));
    translations.add(new Translation(6,"sl","Hello World", "Živjo Svet"));
    translations.add(new Translation(7,"de","Hello World", "Hallo Welt"));
    translations.add(new Translation(8,"fr","Hello World", "Bonjour le monde"));
    translations.add(new Translation(9,"es","Hello World", "Hola Mundo"));
    translations.add(new Translation(10,"it","Hello World", "Ciao Mondo"));

        Iterator<Translation> translationsIterator = translations.iterator();

        while(translationsIterator.hasNext()){

            Translation t = translationsIterator.next();

            translationRepository.save(t);
        }


        System.out.println("Number of languages: " + translationRepository.count());

    }

}
