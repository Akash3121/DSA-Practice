//557. Reverse Words in a String III

#python3
class Solution:
    def reverseWords(self, s: str) -> str:
        words = s.split()
        ans = ""
        for i in range(len(words)):
            ans += words[i][::-1]
            if (i != len(words) - 1):
                ans += " "
        return ans 

#python3
class Solution:
    def reverseWords(self, s: str) -> str:
        return " ".join(word[::-1] for word in s.split(" ")) 