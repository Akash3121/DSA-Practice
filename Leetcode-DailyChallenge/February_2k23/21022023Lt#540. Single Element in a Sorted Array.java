//540. Single Element in a Sorted Array

//Java
class Solution {
    public int singleNonDuplicate(int[] a) {
        int start = 0;
        int end = a.length - 1;
        //binary search
        //ex:1,1,2,3,3,4,4
        //   0,1,2,3,4,5,6, here target is 2, before target if even then a[even] = a[even + 1(odd)] oppositly after target a[odd] = a[odd+1(even)]
        while(start < end){ //start < end because if we found the element, then start = mid, we have end = mid so it will always be same; if we have a case start = end, then it will  be in infinite loop
            int mid = start + (end - start) / 2;
            //if on left side - even - (mid % 2 == 0 && a[mid] == a[mid + 1])

            if ( (mid % 2 == 0 && a[mid] == a[mid + 1]) || (mid % 2 == 1 && a[mid] == a[mid - 1])){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return a[start];   
    }
}