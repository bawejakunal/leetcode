// https://leetcode.com/problems/convert-a-number-to-hexadecimal

public class Solution {
    public String toHex(int num) {
        // Trick: programming languages already represent integer in twos complement
        final Character hexDigit[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder hexNum = new StringBuilder();
        if (num == 0)
            hexNum.append(hexDigit[0]);
        while (num != 0) {
            hexNum.append(hexDigit[num&15]);
            num >>>= 4;
        }
        return hexNum.reverse().toString();
    }
}