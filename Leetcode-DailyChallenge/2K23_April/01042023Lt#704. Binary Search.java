//704. Binary Search

#python3
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start = 0 
        end = len(nums) - 1
        while(start <= end):
            mid = start + (end - start) // 2
            if (nums[mid] < target):
                start = mid + 1
            elif nums[mid] > target:
                end = mid - 1
            else: # equal case 
                return mid
        return -1

//Java
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] < target){
                start = mid + 1;
            } else if (nums[mid] > target){
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
        
    }
}

//Javascript
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let start = 0;
    let end = nums.length -1;
    while (start <= end){
        let mid = start + Math.floor((end - start)/2);
        if (nums[mid] < target){
            start = mid + 1;
        }
        else if(nums[mid] > target){
            end = mid - 1;
        }
        else{
            return mid;
        }
    }
    return -1;
};

// Go
func search(nums []int, target int) int {
    start := 0;
    end := len(nums) - 1;
    for (start <= end){
        mid := start + (end - start) // 2;
        if (nums[mid] < target){
            start = mid + 1;
        } else if nums[mid] > target {
            end = mid - 1;
        } else {
            return mid;
        }
    }
    return -1;
}