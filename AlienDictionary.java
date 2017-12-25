// https://leetcode.com/problems/alien-dictionary/

class Solution {
    public String alienOrder(String[] words) {
        String result = "";
        if (words == null || words.length == 0)
            return result;
        
        Map<Character, Set<Character>> edge = new HashMap<>();
        Map<Character, Integer>indegree = new HashMap<>();
        
        // initialize graph
        for (String w: words) {
            for (char c: w.toCharArray()) {
                if (!edge.containsKey(c)) {
                    indegree.put(c, 0);
                    edge.put(c, new HashSet<Character>());
                }
            }
        }
        
        // build the graph based on edit distance between
        // adjacent words in dictionary
        for (int i = 0; i < words.length - 1; i++) {
            String current = words[i];
            String next = words[i + 1];
            for (int j = 0; j < Math.min(current.length(), next.length());
                j++) {
                char c1 = current.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = edge.get(c1);
                    // add new ordering from c1 to c2
                    if (!set.contains(c2)) {
                        set.add(c2);    // add directed edge from c1 to c2   
                        indegree.put(c2, 1 + indegree.get(c2)); // increment indegree of c2
                    }
                    
                    // current and next differ at c1 and c2 hence break
                    break;
                }
            }
        }
        
        // BFS ordered topological sort
        // Do a topological sort of characters
        // If a loop exists then invalid ordering
        Queue<Character> q = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0)
                q.add(c);
        }
        
        while(!q.isEmpty()) {
            char c = q.poll();
            result += c;    // add to ordered sequence
            
            // unlink all neighbors
            // if a neigbour's indegree becomes 0
            // that indicates absence of loop
            for (char n : edge.get(c)) {
                indegree.put(n, indegree.get(n) - 1);
                if (indegree.get(n) == 0)
                    q.add(n);
            }
        }
        
        // graph had a loop leading to invalid ordering
        if (result.length() != indegree.size())
            result = "";
        
        return result;
    }
}