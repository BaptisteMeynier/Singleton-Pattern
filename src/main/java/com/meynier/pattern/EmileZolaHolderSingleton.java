package com.meynier.pattern;

import java.util.Collections;
import java.util.List;

/**
 * Valid implementation
 */
public class EmileZolaHolderSingleton {

    private static List<String> books = Collections.unmodifiableList(List.of("La Fortune des Rougon","La Curee","Le Ventre de Paris"));

    private EmileZolaHolderSingleton() {
    }

    private static class EmileZolaHolder{
        private final static EmileZolaHolderSingleton instance = new EmileZolaHolderSingleton();
    }

    /** Point d acces pour l instance unique du singleton */
    public static EmileZolaHolderSingleton getInstance()
    {   return EmileZolaHolder.instance;
    }

    public List<String> getBooks(){
        return books;
    }
}
