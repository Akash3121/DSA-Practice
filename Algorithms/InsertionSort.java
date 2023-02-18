import java.util.Arrays;

/*Insertion sort:
 * it is like partially sorting
 * picking an element and inserting in the left side sorted element
 * For every index: put that index element at the correct index of LHS
 * 
 * i loop runs from 0 till n-2 because n-1 array length and -1 is for j{if i runs till n-1 then j = i+1 i.e., n-1+1 = n index out of bound}
 * j is at i + 1 {j numst be grater than 0}
 * as till i the elements before i index are sorted, we need to check j with j-1 if arr[j-1] > arr[j]
 * then we need to swap & j--, goon and break if arr[j-1] < arr[j] i.e, when elem at j is not smaller than elem at j-1 break the loop 
 * {why break? because this left side array is sorted, so not neded to run j till 0}
 * 
 * Complexity:
 * Time: worst case - O(N^2)
 * Best case: O(N) - liner - array already sorted - N-1 comparisions
 * 
 * use case - why to use insertion sort:
 * - Adaptive: means steps get reduced if arrray is sorted
 *      - no.of swaps reduced as compared to bubble sort
 * - stable sort 
 * - used for smalled vales of n - works good when array is partially sorted ->It takes part in hybrid sorting algorithms
 * 
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {-3, 1,0,765,234,345,-2345,5,4,-2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        //first loop till n-2 
        for (int i = 0; i < arr.length - 1; i++) { //means n-2
            // int j = i + 1;
            for (int j = i + 1; j > 0; j--) {
                //check with j-1 and swap
                if (arr[j] < arr[j-1]){
                    //swappning without temp
                    arr[j] += arr[j-1];
                    arr[j-1] = arr[j] - arr[j-1];
                    arr[j] -= arr[j-1];
                    /* swapping with temp
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;

                     */
                } else{ //if elem j is not smaller than j-1 elem then it is alredy sorted so, not necessary to check
                    break;
                }
                
            }
        }
    }    
}
