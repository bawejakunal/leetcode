// https://leetcode.com/problems/multiply-strings/description/

/*
 * product of num1[i] and num2[j] goes to index i + j and i + j + 1
 * total product length cant exceed length of two numbers
 */

class Solution {
    public String multiply(String num1, String num2) {
        int[] answer = new int[num1.length() + num2.length()];

        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int mul = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j)); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + answer[p2];    // add to front of number

                answer[p1] += sum / 10;    // carry digits in p1
                answer[p2] = (sum) % 10;   // replace last digit at p2
            }
        }  

        StringBuilder builder = new StringBuilder();
        for(int p : answer)
            if(!(builder.length() == 0 && p == 0))  // skip leading zero
                builder.append(p);
        return builder.length() == 0 ? "0" : builder.toString();
    }
}