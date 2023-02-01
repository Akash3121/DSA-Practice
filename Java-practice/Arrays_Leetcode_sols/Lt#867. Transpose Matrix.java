//867. Transpose Matrix

class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        if (n==m){
            for(int i = 0; i<n;i++){
            for(int j = i+1; j<n;j++){
                //System.out.println(i+ " " + j);
                int t = matrix[i][j];   
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
            
        }return matrix;
        }
        int[][] b = new int[m][n];
        for(int i = 0; i< n;i++){
            for(int j =0; j< m; j++){
                b[j][i]=matrix[i][j];
            }
        }
        
        return b;
        
        // return matrix;
    }
}