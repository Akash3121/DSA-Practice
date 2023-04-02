//1539. Kth Missing Positive Number

//Java
class Solution {
    public int findKthPositive(int[] arr, int k) {
       //binary search - log(n)
       int start = 0;
       int end = arr.length;
       while(start < end){
           int mid = start + (end - start) / 2;
           if (arr[mid] - mid - 1 < k){
               start = mid + 1;
           } else {
               end = mid;
           }
       }
       return end + k;
    }
}