//1704. Determine if String Halves Are Alike

#python
class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        exp = ["a", "e", "i", "o", "u"]
        a=0
        b=0
        for i in range(len(s)//2):
            if s[i].lower() in exp:
                a += 1
            if s[len(s)-i-1].lower() in exp:
                b+=1
        # print(a,b)
        return a==b