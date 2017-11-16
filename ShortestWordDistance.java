// https://leetcode.com/problems/shortest-word-distance/description/

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        map.put(word1, new ArrayList<Integer>());
        map.put(word2, new ArrayList<Integer>());
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                map.get(word1).add(i);
            else if (words[i].equals(word2))
                map.get(word2).add(i);
        }
        
        int minDist = words.length;
        List<Integer> w1 = map.get(word1);
        List<Integer> w2 = map.get(word2);
        for (Integer a: w1) {
            for (Integer b: w2) {
                if (Math.abs(a-b) < minDist)
                    minDist = Math.abs(a - b);
            }
        }
        return minDist;
    }
}