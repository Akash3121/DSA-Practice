//Search in Infinite Sorted Array
//search an elem in an sorted infinite array, means the end i.e., array length we don't know and can't use
//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/


public class App {
    public static void main(String[] args) throws Exception {
        int a[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        System.out.println(findRange(a, target));
    }
    
    //solution is like, checking the range and if target is b'w the range then following binary search.
    //growing this chunk exponentially will give ans in log(n) time => like start with 1 and then double it ... gives n (bottom up approach of bin search n to 1)
    static int findRange(int[] arr, int target){
        //feist find the range
        //first start with size 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in a range
        //while my target > a[end], keep doubling
        while (target > arr[end]){ //log(n) time 
            int newStart = end + 1; //temp start
            //double the box/chunk value
            //end = previous end value + size of box * 2
            end += (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(arr, target, start, end);
    }
    
    //log(n) time
    static int binarySearch(int[] arr, int target, int start, int end){// BS within range
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (target > arr[mid]){
                start = mid + 1;
            } else if (target < arr[mid]){
                end = mid - 1;
            } else{
                return mid;
            }
        }
        return -1;
    }
}