//1470. Shuffle the Array

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int i = 0;
        int k = 0;
        while(i<n){
            ans[k]=nums[i];
            ans[k+1]=nums[i+n];
            k+=2;
            i++;
        }
        return ans;
    }
}