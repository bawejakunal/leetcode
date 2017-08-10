// https://leetcode.com/problems/pascals-triangle-ii

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> row = new ArrayList<Integer>();
        for (int r = 0; r < rowIndex; r++) {
            row.add(1);
            for (int j = r - 1; j > 0; j--)
                row.set(j, row.get(j) + row.get(j-1));
        }
        return row;
    }
}