// https://leetcode.com/problems/map-sum-pairs/description/

class MapSum {

    private HashMap<String, Integer> map;
    
    /** Initialize your data structure here. */
    public MapSum() {
        this.map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        this.map.put(key, val);
    }
    
    public int sum(String prefix) {
        int total = 0;
        for (Map.Entry<String, Integer> entry : this.map.entrySet()) {
            if (entry.getKey().startsWith(prefix))
                total += entry.getValue();
        }
        return total;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */