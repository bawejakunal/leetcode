"""
    https://leetcode.com/problems/implement-strstr/
"""
class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        i = 0
        i_max = len(haystack) - len(needle)
        while i < i_max:
            if haystack[i:].startswith(needle):
                return i
            i += 1
        
        return -1

def main():
    """
        main method
    """
    solution = Solution()
    print solution.strStr("haystack", "stac")

if __name__ == '__main__':
    main()
