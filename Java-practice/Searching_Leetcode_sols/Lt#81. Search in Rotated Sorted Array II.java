//81. Search in Rotated Sorted Array II

class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
 
            if (nums[mid] == target){
                return true;
            }
            // 3 cases
            // 1- if we know right side is sorted or left side is unsorted
            if (nums[mid] < nums[end]  || nums[mid] < nums[start]){ //purely right side
                //we are here from pivot to end
                if ( target > nums[mid] && target <= nums[end]){ // target is b/w mid and end
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            // 2- if we know left side is sorted or right side is unsorted
            else if( nums[mid] > nums[start] || nums[mid] > nums[end]){
                //we are here from start to pivot
                if ( target < nums[mid] && target >= nums[start]){ // target is b/w mid and end
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // 3- this is 3 equal case, elem at start == mid == end
            //we need to eliminate one duplicate
            else {
                end--;
            }

        }
        return false;
    }
}