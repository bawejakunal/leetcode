// https://leetcode.com/problems/fizz-buzz

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> numbers = new ArrayList<String>();
        for (int i = 1; i <= n;i++) {
            if (i % 15 == 0)
                numbers.add("FizzBuzz");
            else if (i % 5 == 0)
                numbers.add("Buzz");
            else if (i % 3 == 0)
                numbers.add("Fizz");
            else
                numbers.add(Integer.toString(i));
        }
        return numbers;
    }
}