//154. Find Minimum in Rotated Sorted Array II

class Solution:
    def findMin(self, nums: List[int]) -> int:
        lo = 0
        # hi = 0
        hi = len(nums) - 1

        # if not sorted
        if nums[lo] < nums[hi] : 
            return nums[lo]

        while(lo < hi):
            mid = lo + (hi - lo) // 2

            if (nums[mid] > nums[hi]):
                lo = mid + 1
            elif (nums[mid] < nums[hi]):
                hi = mid
            else: #all equal 
                hi -= 1 #reducing the duplicates
        return nums[lo]

//javascript
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let lo = 0;
    let hi = nums.length - 1;

    if (nums[lo] < nums[hi]){
        return nums[lo];
    } 

    while (lo < hi){
        let mid = lo + Math.floor((hi - lo)/2) ;

        if (nums[mid] > nums[hi]){
            lo = mid + 1;
        }
        else if (nums[mid] < nums[hi]){
            hi = mid;
        } else { //eliminating duplicates
            hi --; 
        }
    }
    return nums[lo];
};