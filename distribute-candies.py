# https://leetcode.com/problems/distribute-candies/#/description

from collections import Counter

class Solution(object):
    def distributeCandies(self, candies):
        """
        :type candies: List[int]
        :rtype: int
        """
        types = Counter(candies)
        _total = len(types.keys())
        return min(_total, len(candies)/2)