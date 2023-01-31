//work with ascending or descending order sorted array
public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = {7,5,3,2,1};
        int target = 3;
        System.out.println(orderAgnosticBS(arr, target));
    }

    static int orderAgnosticBS(int[] arr, int target){
        int s = 0;
        int e = arr.length - 1;

        //find wheather the array is sorted in asceing or desceing
        boolean isAsc = arr[s] < arr[e];

        while(s <= e){
            //find the middle element
            //int mid = (s + e)/2 - here s + e might be exceed the max int value in java
            int mid = s + (e - s) / 2;

            if (arr[mid] == target)
                return mid;

            if (isAsc){
                if (target < arr[mid]){
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
            else{
                if (target < arr[mid]){
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }   
        }
        return -1;
    }
}
