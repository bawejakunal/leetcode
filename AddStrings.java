// https://leetcode.com/problems/add-strings/#/description

public class Solution {
    public String addStrings(String num1, String num2) {
        int a, b, c = 0, i, s;
        String first = new StringBuffer(num1).reverse().toString();
        String second = new StringBuffer(num2).reverse().toString();
        StringBuilder builder = new StringBuilder();
        for (i = 0; i < Math.min(first.length(),second.length()); i++) {
            a = Character.getNumericValue(first.charAt(i));
            b = Character.getNumericValue(second.charAt(i));
            s = a + b + c;
            c = s/10;
            s %= 10;
            builder.append(s);
        }
        String longer;
        if (i < first.length())
            longer = first;
        else
            longer = second;
        for (;i < longer.length(); i++) {
            s = c + Character.getNumericValue(longer.charAt(i));
            c = s/10;
            s %= 10;
            builder.append(s);
        }
        if (c > 0)
            builder.append(c);
        return builder.reverse().toString();
    }
}