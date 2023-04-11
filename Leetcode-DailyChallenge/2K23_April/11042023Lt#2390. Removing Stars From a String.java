//2390. Removing Stars From a String

# python3
class Solution:
    def removeStars(self, s: str) -> str:
        ans = []
        for i in s:
            if i == '*':
                ans.pop()
            else:
                ans += [i]
        return "".join(ans)