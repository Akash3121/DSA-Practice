import java.util.*;
public class LinearSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // System.out.println("Enter ")
        int[] arr = {3,1,56,53,876,9};
        int target = 876;
        System.out.println(linearSearch(arr,target));
    }
    static int linearSearch(int[] arr, int target){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if (target == arr[i]){
                return(i);
            }
        }
        return -1;
    }
}