//1854. Maximum Population Year

class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] arr = new int[101];
        for(int i = 0; i < logs.length; i++){
            for(int j = logs[i][0]; j < logs[i][1]; j++){
                arr[j-1950]++;
            }
        }
        int maxyear = 0; int maxvalue = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i]> maxvalue){
                maxvalue = arr[i];
                maxyear = i;
            }
        }
        return maxyear+1950;
    }
}