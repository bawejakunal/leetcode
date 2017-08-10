// https://leetcode.com/problems/complex-number-multiplication/description/

public class Solution {
    public String complexNumberMultiply(String a, String b) {
        // a = "m+ni"
        // b = "x+iy"
        String m[] = a.split("\\+");
        m[1] = m[1].replaceAll("i", "");
        String x[] = b.split("\\+");
        x[1] = x[1].replaceAll("i", "");
        String ans = new String();
        ans += Integer.toString(Integer.parseInt(m[0]) * Integer.parseInt(x[0]) + 
                                Integer.parseInt(m[1]) * Integer.parseInt(x[1]) * -1);
        ans += "+";
        ans += Integer.toString(Integer.parseInt(m[0]) * Integer.parseInt(x[1]) + 
                                Integer.parseInt(m[1]) * Integer.parseInt(x[0]));
        ans += "i";
        return ans;
    }
}