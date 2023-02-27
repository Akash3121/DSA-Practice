//168. Excel Sheet Column Title

#python3
class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        title = ""
        while columnNumber > 0:
            columnNumber -= 1
            letter = chr(columnNumber % 26 + 65) # 6s is ascii value of 'A'
            title = letter + title
            columnNumber   //= 26
        return title