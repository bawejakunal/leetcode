'''
    Find longest commong prefix
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
        
        found = False
        while found is False:
            found = True
            # check if prefix of each string
            for string in strs:
                if not string.startswith(smallest):
                    found = False
                    # reduce size of smallest string
                    smallest = smallest[:-1]
                    break
        
        return smallest