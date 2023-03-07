//2187. Minimum Time to Complete Trips

//Java
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        // Logic: key => low = min value , high = min*totalTrips
        long low = Long.MAX_VALUE;
        long high = 0;
        long min = Long.MAX_VALUE;

        for(int i: time){
            low = Math.min(low, i);
            // min = min(min, i);
        }
        min = low;
        high = totalTrips* low;

        while(low < high){
            long mid = low + (high - low) / 2;
            if (tripsValidate(mid, totalTrips, time)){
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean tripsValidate(long mid, int totalTrips, int[] time){
        long trips = 0;
        for(int i: time){
            trips += mid/i;
        }
        if(trips>=totalTrips)
            return true;
        return false;
    }
}