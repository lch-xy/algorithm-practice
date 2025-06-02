package org.lch.布隆过滤器丨LRU缓存.LRU_Cache_0146;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_1 extends LinkedHashMap<Integer,Integer> {

    int capacity;

    public LRUCache_1(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size() > capacity;
    }

}
