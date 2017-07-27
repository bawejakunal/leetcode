# https://leetcode.com/problems/construct-the-rectangle/

import math

class Solution(object):
    def constructRectangle(self, area):
        """
        :type area: int
        :rtype: List[int]
        """
        w = int(math.floor(math.sqrt(area)))
        while area % w > 0:
            w -= 1
        return [area/w, w]
