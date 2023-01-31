//1672. Richest Customer Wealth
class Solution {
    public int maximumWealth(int[][] accounts) {
        int row = accounts.length;
        int max = 0;
        for (int i = 0; i< row; i++){
            int s =0;
            for (int j = 0; j< accounts[i].length; j++){
                s+=accounts[i][j];
            }
            if (s>max)
                max = s;
        }
        return max;
    }
}