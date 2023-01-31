//566. Reshape the Matrix

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[r][c];
        if ((r*c != n*m) || (r == n && c == m)) return mat;
        for (int i = 0; i < r*c; i++){
            ans[i/c][i%c] = mat[i/m][i%m];
        }
        return ans;
    }
}