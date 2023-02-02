//69. Sqrt(x)

class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int start = 1;
        int end = x;
        //binary search
        while(start <= end){
            int mid = start + (end - start) / 2;
            // mid * mid  = x will be greater than integer so mid = x / mid
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)){
                return mid;
            } else if (mid > x / mid){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;

        //if ( x == 0) return 1;
        // int i = 1;
        // while(i*i <= x) //O(n) 
        //     i++;
        // return i - 1;
    }
}