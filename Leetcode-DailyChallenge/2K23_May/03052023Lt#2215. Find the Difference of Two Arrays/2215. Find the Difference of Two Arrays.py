# 2215. Find the Difference of Two Arrays

#python3
class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        case1, case2 = set(nums1), set(nums2)
        return case1-case2, case2-case1