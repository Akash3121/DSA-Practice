//153. Find Minimum in Rotated Sorted Array

class Solution {
    public int findMin(int[] nums) {
        // Logic: search for the pivot element and return pivot + 1 element, else return first element

        //check if array is rotated or not
        if (nums[0] > nums[nums.length - 1]){ //rotated
            return nums[findPivot(nums) ]; // directly giving the min index
        }
        return nums[0];
    }
    
    public int findPivot(int[] a){
        int start = 0;
        int end = a.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;

            //4 cases
            //2 equal cases
            if (mid < end && a[mid] > a[mid + 1]){//ex: mid = 7
                return mid + 1; //found max, so + 1 = min
            } else if(mid > start && a[mid] < a[mid - 1]){ //ex: mid = 0
                return mid; //returning min
            }

            //traversing cases
            if (a[mid] <= a[start]){
                end= mid - 1;
            } else { 
                start = mid + 1;
            }
        }
        return -1; // it will not come here because the array is unique and it must have a pivot.
    }
}

//python
class Solution:
    def findMin(self, nums: List[int]) -> int:
        lo = 0
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
