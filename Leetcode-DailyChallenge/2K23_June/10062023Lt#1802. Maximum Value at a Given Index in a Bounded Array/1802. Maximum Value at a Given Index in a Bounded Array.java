//1802. Maximum Value at a Given Index in a Bounded Array

//Java
class Solution {
    public int maxValue(int n, int index, int maxSum) {
        //use long in place of int
        long r = n-index-1; //right element = mamElement + 1
        long l = index; //left element = maxElement

        long start = 1;
        long end = maxSum; //for binary search

        long res = 0; //answer

        while(start <= end){
            long mid = start + (end - start) / 2;

            long leftSum = 0;
            long rightSum = 0;

            long sum = mid; //adding mid in sum
            long m = mid - 1;

            //right sum
            if (r <= m){
                rightSum = m*(m+1)/2 - (m-r)*(m-r+1)/2;
            } else { //ading 1's '
                rightSum = m*(m+1)/2 + 1*(r-m);
            }

            //left sum
            if (l <= m){
                leftSum = m*(m+1)/2 - (m-l)*(m-l+1)/2;
            } else{
                leftSum = m*(m+1)/2 + 1*(l-m);
            }

            sum += leftSum + rightSum;

            //traversing
            if (sum <= maxSum){
                res = mid;
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return (int)res;
    }
}