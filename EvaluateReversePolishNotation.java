// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

import java.util.regex.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Pattern operators = Pattern.compile("^[+\\-*/]$");
        for (String token: tokens) {
            if (operators.matcher(token).matches()) {
                int n2 = stack.pop();
                int n1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(n1 + n2);
                        break;
                    case "-":
                        stack.push(n1 - n2);
                        break;
                    case "*":
                        stack.push(n1 * n2);
                        break;
                    case "/":
                        stack.push(n1 / n2);
                        break;
                }
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}