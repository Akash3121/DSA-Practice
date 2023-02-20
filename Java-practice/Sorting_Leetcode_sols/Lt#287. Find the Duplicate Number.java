//287. Find the Duplicate Number

class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # Inplace of sorting we can use cyclic sort so that time = O(N);

        # cyclic sort
        i = 0
        while i < len(nums):
            correct = nums[i] - 1
            if (i != correct) and (nums[i] != nums[correct]) :
                temp = nums[i]
                nums[i] = nums[correct]
                nums[correct] = temp
            else:
                i += 1

        #array sorted

        # now search in array if index != val - 1 then that val is duplicate
        # or
        # it will be the last element because 1 to N elements will be present
        return nums[-1]
        
