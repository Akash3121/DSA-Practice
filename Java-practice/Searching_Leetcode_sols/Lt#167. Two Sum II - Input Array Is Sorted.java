//167. Two Sum II - Input Array Is Sorted

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){ //n times
            int k = binarySearch(nums, target - nums[i], i+1, nums.length-1); //log n times
            if (k!= -1) return new int[] {i+1, k+1};
        }
        int[] a = {-1,-1};
        return a;
    }
    public int binarySearch(int[] a, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (a[mid] < target){
                start = mid + 1;
            } else if(a[mid] > target){
                end = mid - 1;
            } else{
                return mid;
            }
        }
        return -1;
    }
}