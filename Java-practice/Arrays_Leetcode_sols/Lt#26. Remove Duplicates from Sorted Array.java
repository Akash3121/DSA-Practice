//26. Remove Duplicates from Sorted Array

class Solution {
    public int removeDuplicates(int[] nums) {
        //int m = nums[0];
        int k = 0;
        for(int i = 1;i < nums.length;i++){
            if (nums[k] != nums[i]){
                nums[k+1] = nums[i];
                k++;
            }
        }
        return k+1;
    }
}