//2000. Reverse Prefix of Word

#python3
class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        if ch not in word:
            return word
        ind = list(word).index(ch)
        l = (word[:ind + 1][::-1])
        word = list(word)
        word[:ind+1] = l
        return ''.join(word)