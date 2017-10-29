// https://leetcode.com/problems/insert-delete-getrandom-o1/description/

class RandomizedSet {

    private Random random;
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        random = new Random();
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int position = map.get(val);
        if (position < list.size() - 1) {
            int lastElement = list.get(list.size() - 1);
            list.set(position, lastElement);  // move last element to position of deletion
            map.put(lastElement, position);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */