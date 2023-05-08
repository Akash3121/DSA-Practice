//1572. Matrix Diagonal Sum

//Java
class Solution {
    public int diagonalSum(int[][] mat) {
        int s = 0;
        int n = mat.length;
        for (int i = 0; i< n; i++){
            s+= mat[i][i];
            s+=mat[i][n-i-1];
        }
        if (n%2!=0){
            return s - mat[n/2][n/2];
        }
        return s;
    }
}

# python3
class Solution:
    def diagonalSum(self, mat: List[List[int]]) -> int:
        s = 0
        n = len(mat)
        for i in range(n):
            s += mat[i][i]
            s += mat[i][n-i-1]
        if n%2:
            return s - mat[n//2][n//2]
        return s