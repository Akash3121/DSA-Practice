//1732. Find the Highest Altitude

//Java
class Solution {
    public int largestAltitude(int[] gain) {
        int max = Math.max(0,gain[0]);
        for (int i = 1; i< gain.length; i++){
            gain[i] += gain[i-1];
            if (gain[i]>max) max = gain[i];
        }
        return max;
    }
}