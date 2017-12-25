// https://leetcode.com/problems/word-break-ii/description/

class Solution {
    
    private List<String> wordBreak(String s, int start, Set<String> dict,
        Map<Integer, List<String>> map) {
        
        if (map.containsKey(start))
            return map.get(start);  // this substring already explored
        
        List<String> res = new LinkedList<String>();

        // if end of string is reached mark it with empty string in result
        // so we can distinguish between empty list which signigies no valid
        // result and end of string results
        if (start == s.length())
            res.add("");
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end))) {
                List<String> list = wordBreak(s, end, dict, map);
                String prefix = s.substring(start, end);
                
                for (String w: list) {
                    // prepend white space
                    if (!w.isEmpty())
                        w = " " + w;
                    res.add(prefix + w);
                }
            }
        }
        map.put(start, res);
        return res;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String>dict = new HashSet<String>(wordDict);
        Map<Integer, List<String>> map = new HashMap<>();
        return wordBreak(s, 0, dict, map);
    }
}