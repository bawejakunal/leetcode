'''
    https://leetcode.com/problems/count-and-say/
'''

class Solution(object):
    def sequence(self, prev):
        read = str()
        i = 0
        j = i
        while j < len(prev):
            while j < len(prev) and prev[j] == prev[i]:
                j += 1

            read = read + str(j-i) + prev[i]
            i = j

        return read

    def countAndSay(self, number):
        # start from 1
        prev = "1"

        # loop number - 1 times
        for i in range(1, number):
            prev = self.sequence(prev)

        return prev

def main():
    solution = Solution()
    print solution.countAndSay(5)

if __name__ == '__main__':
    main()