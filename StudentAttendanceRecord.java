// https://leetcode.com/problems/student-attendance-record-i/#/description

public class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur  = s.charAt(i);
            if (cur == 'A') {
                countA++;
                if (countA > 1)
                    return false;
            }
            else if (i > 1 && cur == 'L' && s.charAt(i-1) == 'L' && s.charAt(i-2) == 'L')
                return false;
        }
        return true;
    }
}