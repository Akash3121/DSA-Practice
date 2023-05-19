# 785. Is Graph Bipartite

#python3
class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        # TC: O(Edges + Vertices)
        # SC: O(V)
        odd = [0] * len(graph) # Map node i -> odd = 1, even = -1

        def bfs(i):
            if odd[i]: #means not 0, i.e., already visited if it is 1 or -1
                return True
            q = deque([i])
            odd[i] = -1
            while q:
                i = q.popleft()
                for nei in graph[i]:
                    if odd[i] == odd[nei]: #both are even or both are odd
                        return False
                    elif not odd[nei]:
                        q.append(nei)
                        odd[nei] = -1 * odd[i]
            return True

        for i in range(len(graph)):
            if not bfs(i):
                return False
        return True
