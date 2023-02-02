//441. Arranging Coins

class Solution {
    public int arrangeCoins(int n) {
        long nLong = (long)n;
        long start = 1;
        long end = nLong;
        while(start <= end){
            long mid = start + (end - start) / 2;
             if (mid * (mid + 1) <= 2 * nLong){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return (int)start - 1;
    }
}