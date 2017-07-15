// https://leetcode.com/problems/lexicographical-numbers/

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> numbers = new ArrayList<Integer>(n);
        int curr = 1;
        for (int i=1;i<=n;i++) {
            numbers.add(curr);
            if (curr * 10 <= n)
                curr *= 10;
            else if (curr % 10 < 9 && curr < n)
                curr++;
            else {
                // enter this block only when last digit of curr is 9
                // so check for second last digit
                while ((curr / 10) % 10 == 9)
                    curr /= 10;
                curr = (curr / 10) + 1;
            }
        }
        return numbers;
    }
}