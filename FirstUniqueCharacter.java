// https://leetcode.com/problems/first-unique-character-in-a-string/#/description

public class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for (char c: s.toCharArray())
            count.put(c, count.getOrDefault(c, 0) + 1);
        for (int i = 0; i < s.length(); i++) {
            if (1 == count.get(s.charAt(i)))
                return i;
        }
        return -1;
    }
}