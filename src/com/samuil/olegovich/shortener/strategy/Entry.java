package com.samuil.olegovich.shortener.strategy;

import java.io.Serializable;

public class Entry implements Serializable {
    int hash;
    Long key;
    Entry next;
    String value;

    public Entry(int hash, Long key, String value, Entry next) {
        this.key = key;
        this.hash = hash;
        this.next = next;
        this.value = value;
    }

    public Long getKey() {
        return this.key;
    }

    public int hashCode() {
        int result = 1;
        final int prime = 31;
        result = prime * result + value.length();
        result = prime * result + key.toString().length();
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Entry other = (Entry) obj;
        if (this.key != other.key)
            return false;
        if (this.value != other.value)
            return false;
        return true;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return key + "=" + value;
    }
}
