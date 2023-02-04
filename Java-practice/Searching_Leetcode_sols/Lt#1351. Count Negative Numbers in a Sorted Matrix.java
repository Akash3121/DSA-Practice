//1351. Count Negative Numbers in a Sorted Matrix

class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        return str(grid).count('-')

class Solution {
    public int countNegatives(int[][] grid) {
        int mRow = grid.length;//4
        int mCol = grid[0].length;//4

        int ans = 0;

        int row = 0;
        int col = mCol - 1;
        // n + m times, so O(n)
        while(row < mRow && col < mCol && col > -1 && row > -1){
            if (grid[row][col] < 0){ // col skipping
                ans += mRow - row;
                col--;
            } else { //row skipping
                row ++;
            }
        }
        return ans;
        
    }
}