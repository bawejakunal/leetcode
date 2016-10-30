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

def main():
    """
        Main method to create and run solution
    """
    strs = ['HelloWord', 'Helicopter', 'Helsinki', 'king', 'Columbia']
    solution = Solution()
    print solution.longestCommonPrefix(strs)
    print solution.longestCommonPrefix(strs[:3])

if __name__ == '__main__':
    main()
