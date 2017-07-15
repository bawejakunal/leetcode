'''
    https://leetcode.com/problems/reverse-string/
'''
class Solution(object):
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        return s[::-1]

def main():
    """
        Customary main method
    """
    string = "ABCDEF"
    solultion = Solution()
    print solultion.reverseString(string)


if __name__ == '__main__':
    main()
