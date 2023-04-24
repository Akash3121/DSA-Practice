//1046. Last Stone Weight

# python3
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        while(len(stones) > 1):
            stones.sort(reverse = True)
            if (stones[0] == stones[1]):
                stones.pop(1)
                stones.pop(0)
            elif stones[0] != stones[1]:
                stones[0] = stones[0] - stones[1]
                stones.pop(1)
        if len(stones) <1:
            return 0
        return stones[0]