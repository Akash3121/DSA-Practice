# 1502. Can Make Arithmetic Progression From Sequence

#python3
class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        arr.sort()
        absDiff = abs(arr[1] - arr[0])
        for i in range(1, len(arr) - 1):
            if (absDiff != abs(arr[i+1] - arr[i])):
                return False
        return True