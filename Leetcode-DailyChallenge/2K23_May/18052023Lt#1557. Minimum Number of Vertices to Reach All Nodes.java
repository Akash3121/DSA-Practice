//1557. Minimum Number of Vertices to Reach All Nodes

//Java
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer>[] g = new ArrayList[n];
        for(int i = 0; i < n; i ++){
            g[i] = new ArrayList();
        }

        int[] inDegree = new int[n];
        for(List<Integer> e: edges){
            g[e.get(0)].add(e.get(1));
            inDegree[e.get(1)]++;
        }

        List<Integer> result = new ArrayList();
        for(int i = 0; i < n; i ++){
            if (inDegree[i] == 0){
                result.add(i);
            }
        }

        return result;
    }
}

//Java
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        for(List<Integer> edge : edges){
            inDegree[edge.get(1)]++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            if (inDegree[i] == 0){
                ans.add(i);
            }
        }

        return ans;
    }
}

#python3
class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        inDegree = [0] * n
        for edge in edges:
            inDegree[edge[1]] += 1
        
        ans = []
        for i in range(n):
            if (inDegree[i] == 0):
                ans.append(i)
        
        return ans