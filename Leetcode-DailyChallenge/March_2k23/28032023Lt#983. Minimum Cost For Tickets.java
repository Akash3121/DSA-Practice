//983. Minimum Cost For Tickets

#python3
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        # TC: O(38 * N)
        dp = {}

        def dfs(i):
            if i == len(days):
                return 0
            if i in dp:
                return dp[i]

            dp[i] = float("inf") # assigning
            for d, c in zip([1, 7, 30], costs):
                j = i
                while j < len(days) and days[j] < days[i] + d:
                    j += 1
                dp[i] = min(dp[i], c + dfs(j)) #j = i + d
            return dp[i]
        return dfs(0)

#python3
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [0] * (days[-1] + 1)

        travel_days = set(days) # for faster lookups

        for i in range( 1, len(dp)):
            if i in travel_days:
                cost1 = dp[max(i - 1, 0)] + costs[0]
                cost2 = dp[max(i - 7, 0)] + costs[1]
                cost3 = dp[max(i - 30, 0)] + costs[2]
                dp[i] = min(cost1, cost2, cost3) 
            else:
                dp[i] = dp[i - 1] #if not travelday then cost will be same as previous
        
        return dp[-1]