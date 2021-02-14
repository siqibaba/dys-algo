package lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class CacheNode{
        CacheNode prev = null;
        CacheNode next = null;
        int key;
        int value;

        public CacheNode(int key, int value) {
            this.prev = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer,CacheNode> map = new HashMap<>();
    private CacheNode head = new CacheNode(-1,-1);
    private CacheNode tail = new CacheNode(-1,-1);
    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key))return -1;
        CacheNode node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        moveToTail(node);
        return map.get(key).value;
    }

    private void moveToTail(CacheNode node) {
        tail.prev.next = node;
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size()== this.capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        CacheNode node = new CacheNode(key,value);
        moveToTail(node);
        map.put(key,node);
    }
}
