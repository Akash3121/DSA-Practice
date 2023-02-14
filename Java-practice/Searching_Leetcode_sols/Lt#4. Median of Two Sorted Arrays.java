//4. Median of Two Sorted Arrays

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # logic: binary search in one list and then check for the element in other list as we have taken correct or not
        A, B = nums1, nums2
        total = len(A) + len(B)
        half = total // 2

        # we are gonna do binary search on A, swapping if b lenth is less than a with a, as we gonna do bs on a -> to further reduce the time
        if len(B)< len(A):
            A, B = B, A
        
        # binary search on A
        l, r = 0, len(A) - 1
        while True:
            i = (l + r) // 2 # A mid 
            j = half - i -2 # B, -2 is beacuse one for len(B) & other -1 for i 

            Aleft = A[i] if i >= 0 else float("-infinity")
            Aright = A[i+1] if (i+1) < len(A) else float("infinity")
            Bleft = B[j] if j >= 0 else float("-infinity")
            Bright = B[j+1] if (j+1) < len(B) else float("infinity")

            # partition is correct
            if Aleft <= Bright and Bleft <= Aright: 
                #odd
                if total % 2: # 1
                    return min(Aright, Bright)
                else: #even
                    return (max(Aleft, Bleft)+min(Aright, Bright)) / 2
            elif Aleft > Bright:
                r = i - 1
            else:
                l = i + 1