// https://leetcode.com/problems/largest-number/discuss/

class Solution {
    public String largestNumber(int[] nums) {
        String []numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            numStr[i] = Integer.toString(nums[i]);
        Arrays.sort(numStr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String a = s1 + s2; // which combination forms larger number
                String b = s2 + s1; // reverse ordering
                return b.compareTo(a);
            }
        });
        StringBuilder b = new StringBuilder();
        for (String n: numStr) {
            b.append(n);
        }
        // remove leading zeros
        while (b.length() > 1 && b.charAt(0) == '0')
            b.deleteCharAt(0);
        
        return b.toString();
    }
}