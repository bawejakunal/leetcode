// https://leetcode.com/problems/majority-element-ii/description/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<>();
        if (nums == null)
            return l;
        int num1 = 0, num2 = 1, c1 = 0, c2 = 0;
        for (int n: nums) {
            if (n == num1)
                c1++;
            else if (n == num2)
                c2++;
            else if (c1 == 0) {
                c1 = 1;
                num1 = n;
            }
            else if (c2 == 0) {
                c2 = 1;
                num2 = n;
            }
            else {
                c2--;
                c1--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        for (int n: nums) {
            if (n == num1)
                c1++;
            else if (n == num2)
                c2++;
        }
        
        if (c1 > nums.length / 3)
            l.add(num1);
        if (c2 > nums.length / 3)
            l.add(num2);
        return l;
    }
}