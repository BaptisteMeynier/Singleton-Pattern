package com.meynier.pattern;

import java.util.Collections;
import java.util.List;

/**
 * Not valid implementation
 */
public class EmileZolaLocalSynchronizedSingleton {
    private static List<String> books = Collections.unmodifiableList(List.of("La Fortune des Rougon", "La Curee", "Le Ventre de Paris"));

    private EmileZolaLocalSynchronizedSingleton() {
    }

    /**
     * Instance unique pre-initialisee
     */
    private static EmileZolaLocalSynchronizedSingleton INSTANCE = new EmileZolaLocalSynchronizedSingleton();

    /**
     * Point d acces pour l instance unique du singleton
     */
    public static synchronized EmileZolaLocalSynchronizedSingleton getInstance() {
        if (INSTANCE == null)
        {
            synchronized(EmileZolaLocalSynchronizedSingleton.class)
            {
                if (INSTANCE == null)
                {   INSTANCE = new EmileZolaLocalSynchronizedSingleton();
                }
            }
        }
        return INSTANCE;
    }

    public List<String> getBooks() {
        return books;
    }
}
