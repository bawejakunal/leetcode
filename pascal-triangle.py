# https://leetcode.com/problems/pascals-triangle/

class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        pascal = list()
        if numRows > 0:
            for rowlen in range(1, numRows+1):
                if rowlen < 3:
                    row = [1] * rowlen
                else:
                    row = [1]
                    for pos in range(1, rowlen-1):
                        row.append(pascal[-1][pos] + pascal[-1][pos-1])
                    row.append(1)
                pascal.append(row)
        return pascal