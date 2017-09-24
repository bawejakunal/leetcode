// https://leetcode.com/problems/count-numbers-with-unique-digits/description/

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n <= 0)
            return 1;
        
        int ans = 10;           // digits 0-9
        int lastDigit = 9;     // choices for leading digit
        int unique = 9;         // choices for unique numbers
        for (int i = 2; i <= n && lastDigit > 0; i++) {
            unique *= lastDigit--;  // numbers with i unique digits
            ans += unique;          // add to total of unique digit numbers
        }
        return ans;
    }
}