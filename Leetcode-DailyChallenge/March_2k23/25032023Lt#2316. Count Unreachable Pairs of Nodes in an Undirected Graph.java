//2316. Count Unreachable Pairs of Nodes in an Undirected Graph

//Java
class Solution {
    private List<Integer>[] graph;

    public long countPairs(int n, int[][] edges) {
        createGraph(n, edges);
        boolean[] visited = new boolean[n];
        int numVisitedNodes = 0;
        long numUnreachablePairsOfNodes = 0;

        for(int node = 0; node < n; ++node ){
            if (!visited[node]){
                int numNodesInCurrentGroup = dfs_countConnectedNodesInCurrentGroup(node, visited);
                numUnreachablePairsOfNodes += (long) numNodesInCurrentGroup * numVisitedNodes;
                numVisitedNodes += numNodesInCurrentGroup;
            }
        }
        return numUnreachablePairsOfNodes;
    }

    private int dfs_countConnectedNodesInCurrentGroup(int node, boolean[] visited){
        visited[node] = true;
        int numConnectedNodes = 1;

        for (int neighbour: graph[node]){
            if(!visited[neighbour]){
                numConnectedNodes += dfs_countConnectedNodesInCurrentGroup(neighbour, visited);
            }
        }
        return numConnectedNodes;
    }
    private void createGraph(int n, int[][] edges){
        graph = new List[n];
        for(int node = 0; node < n; ++node){
            graph[node] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
    }
}