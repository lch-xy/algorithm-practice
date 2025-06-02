package org.lch.布隆过滤器丨LRU缓存.LRU_Cache_0146;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_2 {

    /**
     * Node存储前后的关系
     * Map查询O(1)的时间复杂度
     * 初始化时，虚拟dummy指针
     * 通过head 和 tail 指针快速处理节点之间的关系、
     */

    class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;
    int capacity;

    Node head, tail;

    public LRUCache_2(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            map.put(key,node);
        }else {
            if (map.size() >= capacity){
                Node node = tail.prev;
                node.prev.next = tail;
                tail.prev = node.prev;
                node.prev = null;
                node.next = null;
                map.remove(node.key);
            }
            Node node = new Node(key,value);
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;

            map.put(key,node);
        }
    }

}
