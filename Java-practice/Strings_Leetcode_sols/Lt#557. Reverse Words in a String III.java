//557. Reverse Words in a String III

#python
class Solution:
    def reverseWords(self, s: str) -> str:
        words = s.split()
        ans = ""
        for i in range(len(words)):
            ans += words[i][::-1]
            if (i != len(words) - 1):
                ans += " "
        return ans 