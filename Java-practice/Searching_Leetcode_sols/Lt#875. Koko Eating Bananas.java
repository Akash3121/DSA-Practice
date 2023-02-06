//875. Koko Eating Bananas

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Logic: k is between 1 and max element in piles
        //so we need to check for each k total hours <= h
        // Brute force: searching in piles is piles.length i.e., n * searching in k from 1 to max of piiles => maxPiles * n(len(piles)) almost O(n^2)
        // we can optimise in this k from 1 to max(piles) as it is already in sorted we can apply binary search - log(maxPiles) * len(piles) almost O(nlogn)

        //using binary search
        int start = 1; //atleast 1 banana
        // int end = Collections.max(Arrays.asList(piles)); 
        int end = Arrays.stream(piles).max().getAsInt(); 
        int res = end;
        while(start <= end){ //logn times
            int mid = start + (end - start) / 2;

            if (checkHours(piles, mid) <= h){ //n times
                end = mid - 1;
                res = Math.min(res,mid);
            } else{ 
                start = mid + 1;
            }
        }

        return res; //mid is the one we are checking
    }
    public int checkHours(int[] piles, int mid){
        int total = 0;
        for(int i = 0; i < piles.length; i++){
            total += Math.ceil(piles[i]*1.0/mid); //*1.0 gives the correct ceil value
        }
        return total;
    }
}