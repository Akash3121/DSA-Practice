//2444. Count Subarrays With Fixed Bounds

//Java
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int minFound = -1, maxFound = -1;
        int start = 0, minStart = 0, maxStart = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < minK || nums[i] > maxK){
                maxFound = -1;
                minFound = -1;
                start = i + 1;
            }
            if (nums[i] == minK){
                minFound = 1;
                minStart = i;
            }
            if (nums[i] == maxK){
                maxFound = 1;
                maxStart = i;
            }

            if (maxFound == 1 && minFound == 1){
                res += (Math.min(minStart, maxStart) - start + 1);
                //substracting start because after that what evere elements are there they will add up
            }
        }
        return res;
    }
}