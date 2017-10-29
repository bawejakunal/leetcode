// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashMap<Character, Integer> positionMap = new HashMap<>();
//         int maxLen = 0;
//         for (int i = 0, j = 0; i<s.length(); i++) {
//             char c = s.charAt(i);
//             if (positionMap.containsKey(c)) {
//                 j = Math.max(j, 1 + positionMap.get(c));
//             }
//             maxLen = Math.max(maxLen, i - j + 1);
//             positionMap.put(c, i);
//         }
//         return maxLen;
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> positionSet = new HashSet<>();
        int maxLen = 0;
        for (int i = 0, j = 0; i < s.length();) {
            char c = s.charAt(i);
            if (positionSet.contains(c)) {
                positionSet.remove(s.charAt(j++)); // remove first char from set
            }
            else {
                positionSet.add(c);
                i++;    // check next character
                maxLen = Math.max(i - j, maxLen);
            }
        }
        return maxLen;
    }
}