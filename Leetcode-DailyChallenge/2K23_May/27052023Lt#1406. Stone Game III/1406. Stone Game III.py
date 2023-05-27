# 1406. Stone Game III

#python3
class Solution:
    def stoneGameIII(self, values: List[int]) -> str:
        dp = {} # caching

        # return (alice - bob), (bob - alice)
        def dfs(i):
            if i == len(values):
                return 0
            if i in dp:
                return dp[i]
            
            res = float("-inf")
            for j in range(i, min(i + 3, len(values))):
                res = max(res, sum(values[i:j+1]) - dfs(j + 1))
            dp[i] = res
            return res

        return "Alice" if dfs(0) > 0 else ("Bob" if dfs(0) < 0 else "Tie")