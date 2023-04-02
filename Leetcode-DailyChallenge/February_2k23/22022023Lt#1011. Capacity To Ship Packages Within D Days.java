//1011. Capacity To Ship Packages Within D Days

//Java
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //start = max element in weights
        //end = sum of weights
        int start = 0;
        int end = 0;

        for(int w : weights){ //n times
            start = Math.max(start, w);
            end += w;
        }

        while (start <= end){ //logn times
            int mid = start + (end - start) / 2;

            int capDay = dayFinder(weights, mid); //n times

            if (capDay <=days){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public int dayFinder(int[] w, int cap){
        int td=0; //temp date
        int ts=0; //temp sum
        for(int i = 0; i < w.length; i++){
            if (ts + w[i] <= cap){
                ts += w[i];
            } else { //greater than capacity
                ts = w[i];
                td++;
            }
        }
        return td + 1; //+1 for last day
    }
}