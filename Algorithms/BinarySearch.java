public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-18, 2, 6, 18, 69, 429, 1897};
        int target = 429;
        System.out.print(binarySearch(arr, target));
    }
    
    //return the index
    //return -1 if doesn't exist
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
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

        return -1;
    }
}
