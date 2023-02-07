//1818. Minimum Absolute Sum Difference

#python
class Solution(object):
    def minAbsoluteSumDiff(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: int
        """
        if nums1 == nums2:
            return 0
        absolute_difference = []
        n= len(nums1)
        sum = 0
        for i in range(n):
            diff = abs(nums1[i] - nums2[i])
            absolute_difference.append(diff)
            sum += diff
        nums1.sort()

        best_diff=[]
        for i in range(n):
            pos = bisect.bisect_left(nums1, nums2[i])
            if pos!=0 and pos!=n: #checking for out of bounds exception
                best_diff.append(min(abs(nums1[pos] - nums2[i]), abs(nums1[pos-1] - nums2[i])))
            elif pos == 0:
                best_diff.append(abs(nums1[pos] - nums2[i]))
            else:
                best_diff.append(abs(nums1[pos-1] - nums2[i]))
        
        saved = []
        for i in range(n): #checking for saved amount to reduce it from sum
            saved.append(absolute_difference[i] - best_diff[i])
        return (sum - max(saved)) % (pow(10,9)+7)
