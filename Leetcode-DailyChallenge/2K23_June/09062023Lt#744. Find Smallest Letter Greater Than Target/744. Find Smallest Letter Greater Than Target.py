# 744. Find Smallest Letter Greater Than Target

#python3
class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        start = 0
        end = len(letters) - 1

        # binary search algo
        while (start <= end):
            mid = start + (end - start) // 2

            if target < letters[mid]:
                end = mid - 1
            else:
                start = mid + 1
        
        return letters[start%len(letters)]