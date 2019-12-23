package com.samuil.olegovich.shortener.strategy;

import java.util.HashMap;

//        Требования:
//        1. Класс OurHashBiMapStorageStrategy должен поддерживать интерфейс StorageStrategy.
//        2. В классе OurHashBiMapStorageStrategy должны быть созданы и инициализированы две HashMap (k2v и v2k).
//        3. Метод containsKey должен проверять содержится ли полученный параметр в k2v.
//        4. Метод containsValue должен проверять содержится ли полученный параметр в v2k.
//        5. Метод put должен добавлять пару (key, value) в k2v и пару (value, key) в v2k.
//        6. Метод getValue должен возвращать значение полученное из k2v.
//        7. Метод getKey должен возвращать значение полученное из v2k.

public class OurHashBiMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> k2v = new HashMap<>();
    private HashMap<String, Long> v2k = new HashMap<>();
    
    @Override
    public boolean containsKey(Long key) {
        return k2v.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return v2k.containsKey(value);
    }

    @Override
    public void put(Long key, String value) {
        k2v.put(key, value);
        v2k.put(value, key);
    }

    @Override
    public Long getKey(String value) {
        return v2k.get(value);
    }

    @Override
    public String getValue(Long key) {
        return k2v.get(key);
    }
}
