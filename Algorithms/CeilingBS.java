/**
 * Ceiling
 */
public class CeilingBS {

    public static void main(String[] args) throws Exception {
        int[] a = {2,3,5,9,14,16,18};
        int target = 19;
        System.out.println(ceilBS(a, target));
    }

    //return the index: lessthan or equal to target
    static int ceilBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        //but if target is greater than largest elem in array, it makes no sense or return last elem
        if (target > arr[end])
            return -1;
        
        //no change in BS algo
        while(start <= end){
            //find the middle element
            //int mid = (start + end)/2 - here start + end might be exceed the max int value in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]){
                end = mid - 1;
            } else if (target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid; // ans found
            }
        }
        return start;//in ceil return start & in floor return end
    }
}