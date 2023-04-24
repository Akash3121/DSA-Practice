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

# python3 - optimized
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        
        max_heap = [-stone for stone in stones]

        heapq.heapify(max_heap)

        while(len(max_heap) > 1):

            stone1 = heapq.heappop(max_heap)
            stone2 = heapq.heappop(max_heap)

            if stone1 != stone2:
                heapq.heappush(max_heap, stone1 - stone2)
        if max_heap:
            return -max_heap[0]
        return 0
