//1380. Lucky Numbers in a Matrix

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] min = new int[m];
        int[] max = new int[n];
        Arrays.fill(min,Integer.MAX_VALUE);
        for(int i = 0; i< m;i++){
            for(int j = 0; j< n; j++){
                if (matrix[i][j]<min[i])
                    min[i] = matrix[i][j];
                if (matrix[i][j]>max[j])
                    max[j] = matrix[i][j];
            }
        }
        //
        for(int i = 0; i< m;i++){
            for(int j = 0; j< n; j++){
                if (min[i] == max[j])
                    ans.add(min[i]);
            }
        }
        return ans;
    }
}