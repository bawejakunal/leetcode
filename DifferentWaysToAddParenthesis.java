// https://leetcode.com/problems/different-ways-to-add-parentheses/description/

class Solution {
    
    private List<Integer> diffWaysToCompute(String input, HashMap<String, List<Integer>> map) {
        if (map.containsKey(input))
            return map.get(input);
        
        List<Integer> results = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer a : left) {
                    for (Integer b : right) {
                        switch (c) {
                            case '-': results.add(a - b);
                                break;
                            case '+': results.add(a + b);
                                break;
                            case '*': results.add(a * b);
                                break;
                        }
                    }
                }
                            
            }
        }
        
        if (results.size() == 0 && input.length() > 0)
            results.add(Integer.valueOf(input));
        
        map.put(input, results);
        
        return results;
    }
    
    public List<Integer> diffWaysToCompute(String input) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        return diffWaysToCompute(input, map);
    }
}