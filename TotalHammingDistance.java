// https://leetcode.com/problems/total-hamming-distance

/* Brian Kernighan's Algorithm  to count set bits in an integer
 * http://www.geeksforgeeks.org/count-set-bits-in-an-integer/
 */

class Solution {
    
    private int hammingDistance(int a, int b) {
        int xor = a ^ b;
        int count = 0;
        while (xor != 0) {
            xor &= (xor - 1);
            count ++;
        }
        return count;
    }
    
    // O(n^2) timeout
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                total += hammingDistance(nums[i], nums[j]);
            }
        }
        return total;
    }
}


// O(n * 32) runtime i.e O(n)
class Solution {
    
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int bits[] = new int[32];
        for (int num: nums) {
            for (int i = 0; i < 32; i++) {
                int x = (1 << i) & num;
                bits[i] += x > 0 ? 1 : 0;
            }
        }
        
        int n = nums.length;
        for (int i = 0; i < 32; i++) {
            total += bits[i] * (n - bits[i]);
        }
        return total;
    }
}