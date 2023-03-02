//1668. Maximum Repeating Substring

//binarysearch
#python3
class Solution:
    def maxRepeating(self, sequence: str, word: str) -> int:
        if word not in sequence:
            return 0
        left = 0
        # right = len(sequence)
        # we can also reduce right as maxseq = len(seq)/len(word)
        right = len(sequence)//len(word)
        while(left <= right):
            mid = left + (right - left) // 2
            if word*mid in sequence:
                left = mid + 1
            else:
                right = mid - 1
        return left-1