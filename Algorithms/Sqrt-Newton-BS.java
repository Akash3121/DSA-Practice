//sqrt(x) less than(nearest) or equal to x ex: x = 10 ans = 3, x = 24 ans = 4
//https://leetcode.com/problems/sqrtx/description/
public class Sqrt {
    public static void main(String[] args) {
        int x = 27;
        System.out.println(findSqrt(x));
    }

    //brute force 
    static int findSqrtBF(int x){
        int i = 1;
        while(i*i <= x) //O(n) 
            i++;
        return i - 1;    
    }

    //Newton method 
    static int findSqrtNM(int x){
        int r = x;
        while(r*r > x){
            r = (r + x/r) /2;
        }
        return (int) r;
    }

    //binary search
    static int findSqrt(int x) {
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
    }

}

