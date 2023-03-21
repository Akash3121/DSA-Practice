//2348. Number of Zero-Filled Subarrays

#python3
class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        cur_sub_zeroes = total_sub_zeroes = 0
        for num in nums:
            if num == 0:
                cur_sub_zeroes += 1
                total_sub_zeroes += cur_sub_zeroes
            else:
                cur_sub_zeroes = 0
        return total_sub_zeroes

//Golang
func zeroFilledSubarray(nums []int) int64 {
    var tot, cur int64 = 0, 0;
    i := 0;
    for i < len(nums){
        if nums[i] == 0{
            cur += 1
            tot += cur
        } else{
            cur = 0
        }
        i++
    }
    return tot;
}