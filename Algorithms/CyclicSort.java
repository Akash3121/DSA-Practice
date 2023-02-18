import java.util.Arrays;

/*Cyclic Sort:
 *  when given no.s from range 1 to N => use cyclic sort ****Very Important***
 *  
 * Algorithm:
 *  Concept: from 1 to N elements after sorted the number/value is like index + 1
 *  {ex: 1,2,3,4,5 - 1 is at 0 index => index = value - 1}
 * 
 * so, only one loop runs till nth elem
 * check the elem is at correct position i.e, val = index - 1 if not swap with correct index/pos
 * again check the first elem only if it is correct pos then move on    
 * 
 * Complexity:
 * Worst case: N-1(for checking the correct pos) + N(after all swpped iteration of for loop) =2N-1 swaps -> 
 *      O(N)
 * 
 * 
 */

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {3,5,4,1,2};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
     }

    private static void cyclicSort(int[] arr) {
        //loop n times
        int i = 0; 
        while (i < arr.length) {
            //check val with index - 1 if not same then swap with correct index
            int k = arr[i] - 1; //desired index
            if( i != k) {
                // swap elem i and elem arr[i]-1
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            } else{
                i++;
            }
        }
    }
}
