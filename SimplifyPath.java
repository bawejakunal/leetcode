// https://leetcode.com/problems/simplify-path/description/

class Solution {
    public String simplifyPath(String path) {
        String[] segments = path.split("/");
        Stack<String> stack = new Stack();
        for (String s: segments) {
            if (s.isEmpty() || s.equals("."))
                continue;
            else if (s.equals("..") && stack.size() > 1) {
                stack.pop();
                stack.pop();
            }
            else {
                stack.push("/");
                stack.push(s);
            }
        }
        
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        if (builder.length() == 0)
            builder.append("/");
        
        return builder.toString();
    }
}