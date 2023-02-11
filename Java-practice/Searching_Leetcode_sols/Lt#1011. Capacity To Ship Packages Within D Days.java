//1011. Capacity To Ship Packages Within D Days

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
            } else {
                ts = w[i];
                td++;
            }
        }
        return td + 1; //+1 for last day
    }
}


//javascript
/**
 * @param {number[]} weights
 * @param {number} days
 * @return {number}
 */
var shipWithinDays = function(weights, days) {
    let start =0;
    let end = 0;

    for(let i = 0; i < weights.length; i++){
        start = Math.max(start, weights[i]);
        end += weights[i];
    }
    
    while (start <= end){
        let mid = start + Math.floor((end - start) / 2); //in js Math.floor is needed for the end-start/2 one

        let td = 0 //tempdate
        let ts = 0; //tempsum

        for(let i = 0; i < weights.length; i++){
            if (ts + weights[i] <= mid){
                ts += weights[i];
            } else {
                ts = weights[i];
                td++;
            }
        }
        td += 1; //for last day

        if (td <= days){
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }

    return start;
};