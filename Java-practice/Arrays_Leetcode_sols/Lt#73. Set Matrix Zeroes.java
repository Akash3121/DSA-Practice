//73. Set Matrix Zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fr = false,fc=false; //first row and columns
        int m = matrix.length;
        int n = matrix[0].length;
        //iterating and putting zero in first row and colum, if the row/col has zero
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //placing zero in all rows and cols if first row,col is zero
        for(int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j]  = 0;
                }
            }
        }
        //if zero is in first col
        if(fc){for(int i = 0; i < m; i++){
            matrix[i][0] = 0;
        }}
         //if zero is in first row
        if(fr){for(int i = 0; i < n; i++){
            matrix[0][i] = 0;
        }}
    }
}