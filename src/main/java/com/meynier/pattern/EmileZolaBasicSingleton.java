package com.meynier.pattern;

import java.util.Collections;
import java.util.List;

/**
 * Valid implementation
 */
public class EmileZolaBasicSingleton {

    private static List<String> books = Collections.unmodifiableList(List.of("La Fortune des Rougon","La Curee","Le Ventre de Paris"));

    private EmileZolaBasicSingleton() {
    }

    /** Instance unique pre-initialisee */
    private static EmileZolaBasicSingleton INSTANCE = new EmileZolaBasicSingleton();

    /** Point d acces pour l instance unique du singleton */
    public static EmileZolaBasicSingleton getInstance()
    {   return INSTANCE;
    }

    public List<String> getBooks(){
        return books;
    }
}
