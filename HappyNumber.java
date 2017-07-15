// https://leetcode.com/problems/happy-number/

public class Solution {
    public boolean isHappy(int n) {
        HashSet seen = new HashSet();
        while (n != 1) {
            int sum = 0;    // sum of the numbers
            // sum of squares of digits
            while (n > 0) {
                int digit = n % 10;
                sum += (digit * digit);
                n /= 10;
            }
            if (seen.contains(sum))
                break;
            seen.add(sum);  // add to hash set
            n = sum;    // replace n
        }
        return n == 1;
    }
}