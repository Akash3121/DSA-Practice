//287. Find the Duplicate Number

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for( int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }
}

//binary search 
//time- O(nlogn)
//space- O(1)
class Solution {
    public int findDuplicate(int[] nums) {
//         According to the Pigeonhole Principle, n+1 integers, placed in an array of length n, at least 1 integer will be repeated.

// So guess a number first(the number mid in the valid range[left,right]), count the elements of the array which is less than or equal to mid in the array.

// If cnt is strictly greater than mid. According to the Pigeonhole Principle, repeated elements are in the interval [left,mid];
// Otherwise, the repeated element is in the interval [mid+1,right].
// With extra O(1) space, without modifying the input.

    int len = nums.length;
    int low = 1;
    int high = len - 1;

    while(low < high) { //logn times binary search
        int mid = low + (high - low) / 2;
        int count = 0;

        for (int i = 0; i < len; i++){ //n times linear loop
            if (nums[i] <= mid){
                count++;
            }
        }

        if (count <= mid){
            low = mid+ 1;
        } else {//strictly greater, then repeated elem in left-mid so high = mid
            high = mid;
        }
    }
    return low; //here low == high
    }
}