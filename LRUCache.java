// https://leetcode.com/problems/lru-cache/description/

class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private int maxCapacity;
    
    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maxCapacity;
            }
        };
    }
    
    public int get(int key) {
        if (this.map.containsKey(key))
            return this.map.get(key);
        return -1;
    }
    
    public void put(int key, int value) {
        this.map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */