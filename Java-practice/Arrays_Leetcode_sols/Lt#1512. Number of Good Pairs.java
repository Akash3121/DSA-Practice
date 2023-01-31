//1512. Number of Good Pairs

class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        dict = {}
        c = 0
        for i in nums:
            if i in dict:
                c+=dict[i]
                dict[i]+=1
            else:
                dict[i]=1
        return c