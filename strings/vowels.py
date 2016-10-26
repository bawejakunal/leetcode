'''
    https://leetcode.com/problems/reverse-vowels-of-a-string/
'''
class Solution(object):
    def reverseVowels(self, string):
        chars = list(string)
        vowels = "aeiouAEIOU"
        stack = list()

        for char in chars:
            if char in vowels:
                stack.append(char)

        for i in range(0, len(chars)):
            if chars[i] in vowels:
                chars[i] = stack.pop()

        return "".join(chars)