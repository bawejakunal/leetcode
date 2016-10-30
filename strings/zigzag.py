'''
    If we are printing string in zigzag fashion, get
    contents of each of the rows, append them and return

    https://leetcode.com/problems/zigzag-conversion/

    P   A   H   N
    A P L S I I G
    Y   I   R

    PAYPALISHIRING
'''

def convert(string, num_rows):
    """
    :type s: str
    :type num_rows: int
    :rtype: str
    """
    if num_rows < 2:
        return string

    rows = ["" for i in range(0, num_rows)]
    down = True
    index = 0

    for char in string:
        rows[index] += char
        # change direction last row
        if index == num_rows - 1:
            down = False
        elif index == 0:
            down = True

        if down is True:
            index += 1
        else:
            index -= 1
    return "".join(rows)


def main():
    """
        Customary main method
    """
    print convert("PAYPALISHIRING", 3)


if __name__ == '__main__':
    main()
