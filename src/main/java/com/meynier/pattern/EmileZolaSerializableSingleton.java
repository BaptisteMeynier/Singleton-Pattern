package com.meynier.pattern;

import java.io.Serializable;

/**
 * Valid implementation
 */
public class EmileZolaSerializableSingleton implements Serializable {
    private EmileZolaSerializableSingleton(){}
    private static EmileZolaSerializableSingleton INSTANCE = new EmileZolaSerializableSingleton();
    public EmileZolaSerializableSingleton getInstance(){return INSTANCE;}
    /** Securite anti-deserialisation */
    private Object readResolve() {
        return INSTANCE;
    }
}
