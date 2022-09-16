package com.comtrade360.assignment.bootstrap;

import com.comtrade360.assignment.data.Translation;
import com.comtrade360.assignment.repositories.TranslationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Component class for bootstrapping application data
 */
@Component
public class BootstrapData implements CommandLineRunner {

    //dependency injection
    private final TranslationRepository translationRepository;

    /**
     * Constructor
     *
     * @param translationRepository
     */
    public BootstrapData(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    /**
     * Adding values to database
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        Set<Translation> translations = new HashSet<>();
        translations.add(new Translation(1, "en", "Hello World", "Helo World"));
        translations.add(new Translation(2, "mk", "Hello World", "Здраво Свету"));
        translations.add(new Translation(3, "sr", "Hello World", "Здраво Свете"));
        translations.add(new Translation(4, "hr", "Hello World", "Pozdrav Svijete"));
        translations.add(new Translation(5, "bg", "Hello World", "Здравей свят"));
        translations.add(new Translation(6, "sl", "Hello World", "Živjo Svet"));
        translations.add(new Translation(7, "de", "Hello World", "Hallo Welt"));
        translations.add(new Translation(8, "fr", "Hello World", "Bonjour le monde"));
        translations.add(new Translation(9, "es", "Hello World", "Hola Mundo"));
        translations.add(new Translation(10, "it", "Hello World", "Ciao Mondo"));

        //looping over each element of the set with translations
        for (Translation translation : translations) {
            //persisting data for every element
            translationRepository.save(translation);
        }
        System.out.println("Number of languages: " + translationRepository.count());

    }

}
