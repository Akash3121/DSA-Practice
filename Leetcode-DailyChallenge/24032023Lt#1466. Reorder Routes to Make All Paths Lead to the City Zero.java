//1466. Reorder Routes to Make All Paths Lead to the City Zero

#python3
class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        # start at city 0
        # recursively check its neighbours
        # count outgoing edges

        # Time: O(N)
        # Space: O(N)
        edges = { (a,b) for (a,b) in connections}
        neighbours = { city: [] for city in range(n)}
        visit = set()
        changes = 0 # answer

        for a,b in connections:
            neighbours[a].append(b)
            neighbours[b].append(a)
    
        def dfs(city):
            nonlocal edges, neighbours, visit, changes

            for neighbour in neighbours[city]:
                if neighbour in visit:
                    continue
                if (neighbour, city) not in edges:
                    changes += 1
                visit.add(neighbour)
                dfs(neighbour)
        
        visit.add(0)
        dfs(0)
        return changes
