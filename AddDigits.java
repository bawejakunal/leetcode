// https://leetcode.com/problems/add-digits/

public class Solution {
    public int addDigits(int num) {
        if (num < 10)
            return num;
        int sum = 0;
        int cpy = num;
        while (cpy > 0) {
            sum += cpy % 10;
            cpy /= 10;
        }
        return addDigits(sum);
    }
}


// public class Solution {
//     public int addDigits(int num) {
//         if (num < 10)
//             return num;
//         int sum = num;
//         int cpy = num;
//         do {
//             cpy = sum;
//             sum = 0;
//             while (cpy > 0) {
//                 sum += cpy % 10;
//                 cpy /= 10;
//             }
//         }while(sum >= 10);
//         return sum;
//     }
// }