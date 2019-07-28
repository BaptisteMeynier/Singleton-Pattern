package com.meynier.pattern;

import java.util.Collections;
import java.util.List;

/**
 * Valid implementation
 */
public class EmileZolaSynchronizedSingleton {
    private static List<String> books = Collections.unmodifiableList(List.of("La Fortune des Rougon", "La Curee", "Le Ventre de Paris"));

    private EmileZolaSynchronizedSingleton() {
    }

    /**
     * Instance unique pre-initialisee
     */
    private static EmileZolaSynchronizedSingleton INSTANCE = new EmileZolaSynchronizedSingleton();

    /**
     * Point d acces pour l instance unique du singleton
     */
    public static synchronized EmileZolaSynchronizedSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EmileZolaSynchronizedSingleton();
        }
        return INSTANCE;
    }

    public List<String> getBooks() {
        return books;
    }
}
