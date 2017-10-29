// https://leetcode.com/problems/top-k-frequent-words/submissions/1

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String word: words)
        {
            if(map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                if (a.getValue() == b.getValue()) {
                    return b.getKey().compareTo(a.getKey());
                }
                return a.getValue() - b.getValue();
            }
        });
        
        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);    // insert to priorityqueue
            if(pq.size() > k)
                pq.poll();
        }

        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());
        
        return result;
    }
}