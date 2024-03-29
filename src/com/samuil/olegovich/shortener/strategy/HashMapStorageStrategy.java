package com.samuil.olegovich.shortener.strategy;

import java.util.HashMap;
import java.util.Map;


public class HashMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> data = new HashMap();

    @Override
    // должен вернуть true, если хранилище содержит переданный ключ.
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    // должен вернуть true, если хранилище содержит переданное значение.
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    // добавить в хранилище новую пару ключ - значение.
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    // вернуть ключ для переданного значения.
    public Long getKey(String value) {

        if (value == null || value.isEmpty()){
            throw new IllegalArgumentException();
        }

        for (Map.Entry<Long, String> pair : data.entrySet()){
            if(value.equals(pair.getValue())){
                return pair.getKey();
            }
        }
        return null;
    }

    @Override
    // вернуть значение для переданного ключа.
    public String getValue(Long key) {
        return data.get(key);
    }
}
