// row wise & column wise sorted, search
import java.util.Arrays;

public class SearchinRowwiseColwisesortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {17, 27, 37, 47}
            // {19, 29, 39, 49}
        };
        System.out.println(Arrays.toString(search(arr, 35)));
    }

    //O(n) i.e., n times row and m times col traversal, so n+m = 2n = O(n)
    //starting point is first row last column (key to this algo)
    static int[] search(int[][] arr, int target){
        int row = 0;
        int col = arr[0].length - 1;
        while (row < arr.length && col < arr[0].length){
            if (target == arr[row][col]){
                return new int[] {row, col};
            } else if (target < arr[row][col]){ // since the col is sorted 
                // if target is less than the present first element in the col then the element is not present in the entire column, 
                // because target is less than first element in that column
                col--;
            } else { // if target is > first element in col then it not be in the row so row ++ 
                row++;
            }
        }
        return new int[] {-1, -1};
    }
}
