// https://leetcode.com/problems/valid-anagram/

public class Solution {
    public boolean isAnagram(String s, String t) {        

        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++)
            count.put(s.charAt(i), 1 + count.getOrDefault(s.charAt(i), 0));
        for (int i = 0; i < t.length(); i++) {
            if (!count.containsKey(t.charAt(i)) || count.get(t.charAt(i)) == 0)
                return false;
            count.put(t.charAt(i), -1 + count.get(t.charAt(i)));
        }
        
        for (Map.Entry<Character, Integer> e: count.entrySet()) {
            if (e.getValue() > 0)
                return false;
        }
        return true;
    }
}