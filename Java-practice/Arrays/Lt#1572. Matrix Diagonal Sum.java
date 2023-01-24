//1572. Matrix Diagonal Sum

class Solution {
    public int diagonalSum(int[][] mat) {
        int s = 0;
        int n = mat.length;
        for (int i = 0; i< n; i++){
            s+= mat[i][i];
            s+=mat[i][n-i-1];
        }
//if the matrix length is odd, then we need to remove the middle elem in matrix as it came twice.
        if (n%2!=0){
            return s - mat[n/2][n/2];
        }
        return s;
    }
}