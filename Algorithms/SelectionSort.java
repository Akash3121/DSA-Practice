import java.util.Arrays;

/*Selection sort:
 * select an element and put it at it's right position/index.
 * 2ways - selecting max  elem and put it at end or selecting min elem and put at it's first.
 * Time: O(N^2)
 * Best & Worst case: both are O(N^2)
 * best case O(N^2) because selecting max elem for all loops.
 * Not a stable sort
 * Use case: performs well on small lists/arrays
*/

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3,1,65};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selection(int[] arr) { //swapping maximum elems to end
        //first loop n times
        for (int i = 0; i < arr.length; i++) {
            // find the max item in the remaining array and swap with correct index
            int last = arr.length - i - 1; //last element
            int maxIndex = getMaxIndex(arr, 0, last); //find max elem in the given range start to end i.e., 0 to last
            
            swap(arr, maxIndex, last); //just swapping
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) { // n times
            if (arr[i] > arr[max]){
                max = i; 
            }
        }
        return max;
    }

    
}
