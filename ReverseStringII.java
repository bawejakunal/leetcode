// https://leetcode.com/problems/reverse-string-ii/#/description

public class Solution {
    
    private void reverse(char []chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
    
    public String reverseStr(String s, int k) {
        char []chars = s.toCharArray();
        for (int i = 0; i < chars.length; i+=2*k) {
            reverse(chars, i, Math.min(i + k - 1, s.length()-1));
        }
        return new String(chars);
    }
}


// Another solution

// public class Solution {
    
//     public String reverseStr(String s, int k) {
//         StringBuilder builder = new StringBuilder();
//         int k2 = 2*k;
//         for (int i = 0; i < s.length(); i+=k) {
//             int end = Math.min(i + k, s.length());
//             if ((i + k) % k2 == k) {
//                 StringBuilder b = new StringBuilder(s.substring(i, end));
//                 builder.append(b.reverse().toString());
//             }
//             else
//                 builder.append(s.substring(i, end));
//         }
//         return builder.toString();
//     }
// }