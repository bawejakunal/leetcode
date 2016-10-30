class Solution(object):
    def isPalindrome(self, s):
        length = len(s)
        mid = length/2
        first = s[:mid]
        second = s[length-mid:]
        return second == first[::-1]
        
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        length = len(s)
        while length > 0:
            if self.isPalindrome(s[:length]):
                break
            length -= 1
        
        return s[length:][::-1] + s

def main():
    string = "abcdeefdcs"

    solution = Solution()
    print solution.shortestPalindrome(string)
if __name__ == '__main__':
    main()