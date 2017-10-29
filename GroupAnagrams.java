// https://leetcode.com/problems/group-anagrams/description/

class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String a: strs) {
            char[] characters = a.toCharArray();
            Arrays.sort(characters);    // sorted order
            String s = String.valueOf(characters);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(a);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}