//1886. Determine Whether Matrix Can Be Obtained By Rotation

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        // rotate 90deg = transpose -> reverse each row
        boolean b  = false;
        int k = 4;
        while (k>0){
            if (Arrays.deepEquals(mat,target))
                return true;
            rotate(mat);
            k--;
        }
        return false;
        
    }
    public int[][] rotate(int[][] mat){
        int n = mat.length;
        //transpose a matrix
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                int t = mat[i][j];
                mat[i][j]= mat[j][i];
                mat[j][i] = t;
            }
        }
        //reverse a row in matrix
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n/2; j++){
                int t = mat[i][j];
                mat[i][j]= mat[i][n-j-1];
                mat[i][n-j-1] = t;
            }
        }
        return mat;
    }
}