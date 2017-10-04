// https://leetcode.com/problems/generate-parentheses/description/

class Solution {
    
    private void generateParenthesis(List<String> parenthesis,
                    String permutation, int left, int right) {
        // unbalanced backtrack
        if (right < left)
            return;
        
        // generated valid pair
        if (left == 0 && right == 0)
            parenthesis.add(permutation);
        
        // explore branches
        if (left > 0)
            generateParenthesis(parenthesis, permutation + "(", left - 1,
                                right);
        if (right > 0)
            generateParenthesis(parenthesis, permutation + ")", left,
                                right - 1); 
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<String>();
        generateParenthesis(parenthesis, "", n, n);
        return parenthesis;
    }
}