'''
    Find longest commong prefix
    Better than previous commit
    https://leetcode.com/problems/longest-common-prefix/
'''

class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        # smallest string
        try:
            smallest = min(strs)
        except ValueError:
            return ''

        for string in strs:
            while not string.startswith(smallest):
                smallest = smallest[:-1]

        return smallest
