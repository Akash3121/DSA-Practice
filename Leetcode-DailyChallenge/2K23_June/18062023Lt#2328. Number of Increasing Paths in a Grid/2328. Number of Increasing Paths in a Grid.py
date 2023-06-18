# 2328. Number of Increasing Paths in a Grid

#python3
class Solution:
    def countPaths(self, grid: List[List[int]]) -> int:

        rows = len(grid)
        cols = len(grid[0])
        mod = 10**9 + 7

        @lru_cache(None) # gives TLE without this
        def dfs(row, col):
            res = 1
            for dx, dy in [[row, col + 1], [row + 1, col], [row - 1, col], [row, col - 1]]:
                if 0 <= dx < rows and 0 <= dy < cols and grid[dx][dy] > grid[row][col]:
                    res += dfs(dx, dy)
            return res


        count_val = []
        for i in range(rows):
            for j in range(cols):
                count_val.append(dfs(i, j))

        return sum(count_val)%mod