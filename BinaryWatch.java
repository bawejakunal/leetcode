// https://leetcode.com/problems/binary-watch/#/description

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new LinkedList<String>();
        for (int hr = 0; hr < 12; hr++) {
            int hCount = Integer.bitCount(hr);
            for (int mi = 0; mi < 60; mi++) {
                if (Integer.bitCount(mi) + hCount == num)
                    times.add(String.format("%d:%02d", hr, mi));
            }
        }
        return times;
    }
}