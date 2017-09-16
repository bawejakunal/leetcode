// https://leetcode.com/problems/top-k-frequent-elements/description/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> valMap = new HashMap<>();
        for (int num: nums) {
            valMap.put(num, valMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Tuple> q = new PriorityQueue<Tuple>(k, new TupleComparator());
        for (Map.Entry<Integer, Integer> entry : valMap.entrySet()) {
            Tuple t = new Tuple(entry.getKey(), entry.getValue());
            q.add(t);
        }
        
        List<Integer> topK = new ArrayList<Integer>(k);
        for (int i = 0; i < k && !q.isEmpty();i++) {
            Tuple t = q.poll();
            topK.add(t.val);
        }
        return topK;
    }
}

class Tuple {
    Integer val;
    Integer freq;
    Tuple(Character ch, Integer freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class TupleComparator implements Comparator<Tuple> {
    @Override
    public int compare (Tuple a, Tuple b) {
        return b.freq - a.freq;
    }
}