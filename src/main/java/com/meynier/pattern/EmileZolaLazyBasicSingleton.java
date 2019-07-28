package com.meynier.pattern;

import java.util.Collections;
import java.util.List;
/**
 * Not valid implementation
 */
public class EmileZolaLazyBasicSingleton {

    private static List<String> books = Collections.unmodifiableList(List.of("La Fortune des Rougon", "La Curee", "Le Ventre de Paris"));

    private EmileZolaLazyBasicSingleton() {
    }

    /**
     * Instance unique pre-initialisee
     */
    private static EmileZolaLazyBasicSingleton INSTANCE = null;

    /**
     * Point d acces pour l instance unique du singleton
     */
    public static EmileZolaLazyBasicSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EmileZolaLazyBasicSingleton();
        }
        return INSTANCE;
    }

    public List<String> getBooks() {
        return books;
    }
}
