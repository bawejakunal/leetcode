// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

class Solution {
    
    private static HashMap<Character, String> map;
    static {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    
    private void findCombinations(List<String> combinations, String digits,
        int idx) {
        
        // end reached
        if (idx >= digits.length())
            return;
        
        int total = combinations.size();
        String chars = map.get(digits.charAt(idx));
        
        if (total == 0) {
            for (int j = 0; j < chars.length(); j++) {
                combinations.add(chars.charAt(j) + "");
            }
        }
        else {
            for (int i = 0; i < total; i++) {
                String first = combinations.get(0);
                combinations.remove(0);
                for (int j = 0; j < chars.length(); j++) {
                    combinations.add(first + chars.charAt(j));
                }
            }
        }
        
        findCombinations(combinations, digits, idx + 1);
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new LinkedList<String>();
        for (int i = 0; i < digits.length(); i++) {
            if (!map.containsKey(digits.charAt(i)))
                return combinations;    // cant generate for invalid string
        }
        findCombinations(combinations, digits, 0);
        return combinations;
    }
}