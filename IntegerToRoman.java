// https://leetcode.com/problems/integer-to-roman/discuss/

class Solution {
    
    private static final LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }
    
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        
        for (Integer key : this.map.keySet()) {
            int q = num / key;
            num %= key;
            while (q-- > 0) {
                roman.append(this.map.get(key));
            }
        }
        
        return roman.toString();
    }
}