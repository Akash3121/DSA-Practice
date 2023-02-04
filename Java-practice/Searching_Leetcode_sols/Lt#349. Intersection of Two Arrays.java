//349. Intersection of Two Arrays

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        a = []
        for i in nums1:#n times
            if i in nums2: #n times
                if i not in a:
                    a.append(i)
        return a