package com.craftdemo.contentauthoringtool.cache;

public interface ICacheAccessor<K,V> {
    void put(K key, V value);
    V get(K key);
}
