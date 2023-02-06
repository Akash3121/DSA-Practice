//436. Find Right Interval

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        if (n == 1){ // we don't have any other element to check
            return new int[]{-1};
        }

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++){ //placing start elements and its index in map
            map.put(intervals[i][0],i);
        }

        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            Integer key = map.ceilingKey(intervals[i][1]); //checking end elem in map
            result[i] = key == null ? -1 : map.get(key);
        }

        return result;
        
    }
}