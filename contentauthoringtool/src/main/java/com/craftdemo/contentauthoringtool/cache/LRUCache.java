package com.craftdemo.contentauthoringtool.cache;

import com.craftdemo.contentauthoringtool.utility.ILogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;

@Service
public class LRUCache<K,V> implements ICacheAccessor<K,V>{
    @Autowired
    private ILogger logger;
    int capacity = 2;
    LinkedList<K> list= new LinkedList<>();
    HashMap<K,V> map = new HashMap<>();
    @Override
    public void put(K key, V value) {
        if(map.containsKey(key)){
            list.remove(key);
            list.addFirst(key);
        }
        else if(list.size()==capacity){
            K lastKey = list.removeLast();
            map.remove(lastKey);
            list.addFirst(key);
            map.put(key,value);
        }
        else {
            list.addFirst(key);
            map.put(key,value);
        }
        logger.logInfo("Updated the "+key+" in the cache");
    }

    @Override
    public V get(K object) {
        if(map.containsKey(object)){
            list.remove(object);
            list.addFirst(object);
        }
        logger.logInfo("Reading schema from cache");
        return map.get(object);
    }
}
