//74. Search a 2D Matrix

//linear m+n - didn't submitted as they asked for log(m+n) sol
class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m = mat.length; //rows
        int n = mat[0].length; //cols

        //starting with first row last element
        int row = 0;
        int col = n - 1;
        //O(m+n)
        while (row < m && col < n && row >= 0 && col >= 0){
            if (mat[row][col] == target){
                return true;
            } else if (mat[row][col] > target){
                col --;
            } else { //mat[row][col] < target 
                row ++;
            }
        }
        return false;
        
    }
}