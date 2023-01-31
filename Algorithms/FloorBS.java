public class FloorBS {
    public static void main(String[] args) throws Exception {
        int[] a = {2,3,5,9,14,16,18};
        int target = 15;
        System.out.println(floorBS(a, target));
    }

    //return index: greatest elem lessthan or equal to target
    static int floorBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        //if the target is less than lowest elem in array, it will directly print -1, edge case not  needed.

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

        return end;
    }
}
