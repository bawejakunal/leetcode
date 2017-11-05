// https://leetcode.com/problems/decode-ways/description/

class Solution {
    
    private int numDecodings(String s, HashMap<String, Integer> ways) {
        if (s.isEmpty())
            return 1;   // found 1 valid decoding
        
        // memoized solution
        if (ways.containsKey(s))
            return ways.get(s);
        
        int count = 0;
        
        // if first digit is valid
        int code = Integer.parseInt(s.substring(0, 1));
        if (1 <= code && code <= 26) {
            count += numDecodings(s.substring(1), ways);    // pick first digit if valid
        
            // pick second digit if possible
            if (s.length() > 1) {
                code = Integer.parseInt(s.substring(0, 2)); // decode two digits
                if (1 <= code && code <= 26)                // pick two digits if valid
                    count += numDecodings(s.substring(2), ways);
            }
        }
        
        ways.put(s, count); // memoize solution
        return count;
    }
    
    public int numDecodings(String s) {
        if (s == null || s.isEmpty())
            return 0;   // cant decode empty string
        HashMap<String, Integer> ways = new HashMap<>();
        return numDecodings(s, ways);
    }
}