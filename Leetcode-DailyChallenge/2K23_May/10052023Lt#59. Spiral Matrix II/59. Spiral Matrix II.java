//59. Spiral Matrix II

//Java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int k = 1;
        int startRow=0;int endRow = n-1;int startCol = 0;int endCol=n-1;
        while(k<=n*n && startRow <= endRow && startCol <= endCol){
            //first row
            for(int i = startCol; i <= endCol; i++){
                ans[startRow][i]=k;
                k++;
            }
            startRow++;
            //last col
            for(int i = startRow; i <= endRow; i++){
                ans[i][endCol]=k;
                k++;
            }
            endCol--;
            //last row
            for(int i = endCol; i >= startCol; i--){
                ans[endRow][i]=k;
                k++;
            }
            endRow--;
            //first col
            for(int i = endRow; i >= startRow; i--){
                ans[i][startCol]=k;
                k++;
            }
            startCol++;
        }
        return ans;
    }
}