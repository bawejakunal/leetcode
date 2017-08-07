// https://leetcode.com/problems/word-pattern/description/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String []words = str.split(" ");
        char[] keys = pattern.toCharArray();
        if (keys.length != words.length)
            return false;
        
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashMap<String, Character>revMap = new HashMap<String, Character>();
        
        for (int i = 0; i < keys.length; i++) {
            if (!map.containsKey(keys[i]) && !revMap.containsKey(words[i])) {
                map.put(keys[i], words[i]);
                revMap.put(words[i], keys[i]);
            }
            else {
                if (map.containsKey(keys[i]) && !map.get(keys[i]).equals(words[i]))
                    return false;
                if (revMap.containsKey(words[i]) && !revMap.get(words[i]).equals(keys[i]))
                    return false;
            }
        }
        return true;
    }
}