//410. Split Array Largest Sum
//https://leetcode.com/problems/split-array-largest-sum/description/
public class SplitArray {
    public static void main(String[] args) {
        int[] a = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(a, k));
    }
    static int splitArray(int[] nums, int m){
        int start = 0;
        int end = 0;

        //logic follows as the min subarray is between max element and total sum of the array
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); //in the end of the loop this will contain max item from the array
            end += nums[i]; //sum of all elems in array
        }

        //binary search
        while(start < end){
            // try for the middle as potential ans
            int mid = start + (end - start) / 2;

            //caluclate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1; //initially you can divide atleast 1 piece/ partition
            for (int num : nums) {
                if (sum + num > mid){
                    //you cannot add this in subarray(subarray sum is exceeding mid), make new one
                    //say you add this in a new subarray, then sum = num
                    sum = num;
                    pieces++;
                } else{
                    sum += num;
                } 
            }

            if (pieces > m){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end; //here start == end
    }
}

//python
class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        def canSplit(largest):
            subArray = 0
            currSum = 0
            for n in nums:
                currSum += n
                if currSum >largest:
                    subArray += 1
                    currSum = n
            return subArray + 1 <= k # + 1 is for the last sub array



        l, r = max(nums), sum(nums)
        res = r
        while l<= r: #logn times
            mid = l + ((r-l) // 2)

            if canSplit(mid): #n times
                res = mid
                r = mid - 1
            else:
                l = mid + 1
        return res

                
