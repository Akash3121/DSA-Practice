//18. 4Sum

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        # Logic: creating a kSum function and passing value k = 4 as requirement is quadriples
        # a recursive kSum function in which reducing the k, if k == 2, the base case then it's two sum using two pointer
        nums.sort() 
        res, quad = [], []

        def kSum(k, start, target): #not passing nums because nums can be accessibles inside the function and passing target because every time target reduces.
            if k!=2: #not a 2 sum
                for i in range(start, len(nums) - k + 1): #loop need to run till last - 4 the element, +1 is for 0 indexed
                    if i > start and nums[i] == nums[i - 1]: #duplicate value
                        continue
                    quad.append(nums[i])
                    kSum(k - 1, i + 1, target - nums[i]) #recursive function
                    quad.pop()
                return #this will not hit as if k == 2 then reduing
            
            #base case - two sum ; similar to two sum II problem
            l, r = start, len(nums) - 1
            while(l < r):
                if nums[l] + nums[r] < target:
                    l += 1
                elif nums[l] + nums[r] > target:
                    r -= 1
                else: #nums[l] + nums[r] == target ; equal case
                    res.append(quad + [nums[l], nums[r]])
                    l += 1
                    while l < r and nums[l] == nums[l - 1]: #checking for duplicate value with previous value
                        l += 1
        kSum(4, 0, target)
        return res
