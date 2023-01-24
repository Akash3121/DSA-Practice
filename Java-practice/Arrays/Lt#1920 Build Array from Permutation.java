//1920. Build Array from Permutation
class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i =0; i<nums.length; i++){
            nums[i]+= (n*(nums[nums[i]]%n));
        }
        for (int i = 0; i <n; i++){
            nums[i]/=n;
        }
        return nums;
    }
}