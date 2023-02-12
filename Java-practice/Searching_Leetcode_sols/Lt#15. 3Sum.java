//15. 3Sum


//python
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # logic is fixing the first element (n times) ant then using the two pointer
        res=[]
        nums.sort() #nlogn times

        for i, a in enumerate(nums):
            if i>0 and a == nums[i - 1]: #skip the duplicate value
                continue
            l = i+1
            r=len(nums)-1
            while(l<r):
                sum = a+nums[l]+nums[r]
                if sum > 0:
                    r -= 1
                elif sum < 0:
                    l += 1
                else: #equal case i.e., sum = 0
                    res.append([a, nums[l], nums[r]])
                    l += 1
                    # now check for the duplicate value with l-1 previous value
                    while (nums[l] == nums[l - 1] and l<r): #l<r because we incremented l+1, there might be a case l exceeds r
                        l += 1
        return res