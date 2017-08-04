// https://leetcode.com/problems/number-of-segments-in-a-string/

import java.util.regex.*;

public class Solution {
    public int countSegments(String s) {
        String t = s.trim();
        int cnt = 0;
        if (t.length() > 0) {
            cnt++;
            Pattern p = Pattern.compile("[ ]+");
            Matcher m = p.matcher(t);
            while (m.find())
                cnt++;
            
        }
        return cnt;
    }
}


// public class Solution {
//     public int countSegments(String s) {
//         int cnt = 0;
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i-1) == ' '))
//                 cnt++;
//         }
//         return cnt;
//     }
// }