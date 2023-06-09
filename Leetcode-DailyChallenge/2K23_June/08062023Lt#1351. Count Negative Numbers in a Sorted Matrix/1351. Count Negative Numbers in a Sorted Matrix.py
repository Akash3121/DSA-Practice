# 1351. Count Negative Numbers in a Sorted Matrix

#python3
class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        return str(grid).count('-')