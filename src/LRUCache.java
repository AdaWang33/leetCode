import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */

public class LRUCache {
    List<int[]> elements;
    int cap;

    public LRUCache(int capacity) {
        elements = new ArrayList<>();
        cap = capacity;
    }

    public int get(int key) {
        for (int i = elements.size() - 1; i >= 0; i--) {
            int[] ele = elements.get(i);
            if (ele[0] == key) {
                int res = ele[1];
                elements.remove(i);
                put(key, res);
                return res;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        boolean has = false;
        for (int i = elements.size() - 1; i >= 0; i--) {
            int[] ele = elements.get(i);
            if (ele[0] == key) {
                has = true;
                elements.remove(i);
                put(key, value);
            }
        }
        if (!has) {
            if (elements.size() == cap) {
                delete();
            }
            int[] pair = {key, value};
            elements.add(pair);
        }
    }

    public void delete() {
        elements.remove(0);
    }

}
