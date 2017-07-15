"""
    Practise question
"""
def maxlength(words):
    """
        sample question
    """
    dictionary = dict()

    for word in words:
        dictionary[word] = 1

    """
        The run time for words.sort() is O(nlg(n))
        which can be reduced to O(n) by using bucket
        concept to group words by their lengths.
    """
    words.sort(key=len)
    maxchain = 0
    for word in words:
        current = dictionary[word]
        for i in xrange(len(word)):
            temp = word[:i] + word[i+1:]

            if temp in dictionary:
                current = max(current, dictionary[temp]+1)

        dictionary[word] = current
        maxchain = max(maxchain, current)

    return maxchain

def main():
    """
        driver method
    """
    words = ['a', 'b', 'ba', 'bca', 'bda', 'bdca']
    print maxlength(words)

if __name__ == '__main__':
    main()
