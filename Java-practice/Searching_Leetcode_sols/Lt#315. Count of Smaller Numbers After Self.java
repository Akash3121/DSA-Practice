//315. Count of Smaller Numbers After Self

#python
class Solution:
    # def countSmaller(self, nums: List[int]) -> List[int]:
        # def countSmaller(self, nums):
    def countSmaller(self, nums):
        counts = []
        done = []
        for num in nums[::-1]:
            counts.append(bisect.bisect_left(done, num))
            bisect.insort(done, num)
        return counts[::-1]