//888. Fair Candy Swap

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        //logic is sort bob array then for each elem in alicesize binary search in bobsize 
        //mid = asum+bsum/2
        // bs input target is bsum + alice each element - mid
        int aSum = Arrays.stream(aliceSizes).sum();
        int bSum = Arrays.stream(bobSizes).sum();

        Arrays.sort(bobSizes);
        int mid = aSum + (bSum - aSum) / 2;
        for (int i : aliceSizes){
            int a = Arrays.binarySearch(bobSizes, (bSum + i) - mid);
            if (a >= 0){
                return new int[] {i, bobSizes[a]};
            }
        }
        return new int[]{-1,-1};
    }
}