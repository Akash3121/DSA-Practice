//1345. Jump Game IV

//Java
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> valIndex = new HashMap();
        for (int i = 0; i < n; i++){
            valIndex.computeIfAbsent(arr[i], l -> new ArrayList()).add(i);
        }
        
        Queue<Integer> q = new LinkedList();
        Set<Integer> visited = new HashSet();

        q.add(0);
        visited.add(0);
        int steps = 0;

        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                int i = q.poll();
                if (n-1 == i){
                    return steps;
                }
                List<Integer> addList = valIndex.get(arr[i]);
                addList.add(i-1);
                addList.add(i+1);
                for(int j: addList){
                    if (j >= 0 && j < n && !visited.contains(j)){
                        q.add(j);
                        visited.add(j);
                    }
                } 
                addList.clear(); 
            }
            steps ++;
        }
        return -1;
    }
}


#python3
class Solution:
    def minJumps(self, arr: List[int]) -> int:
        n = len(arr)
        if n <= 1:
            return 0
        
        graph = {}
        for i in range(n):
            if arr[i] in graph:
                graph[arr[i]].append(i)
            else:
                graph[arr[i]] = [i]
        
        curs = [0]
        visited = {0}
        step = 0

        while curs:
            nex = []

            for node in curs:

                #if reached
                if node == n -1:
                    return step
                
                for child in graph[arr[node]]:
                    if child not in visited:
                        visited.add(child)
                        nex.append(child)

                graph[arr[node]].clear()

                for child in [node - 1, node + 1]:
                    if 0 <= child < len(arr) and child not in visited:
                        visited.add(child)
                        nex.append(child)
            curs = nex
            step += 1
        return -1
        



        