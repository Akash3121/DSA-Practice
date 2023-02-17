import java.util.Arrays;

//also known as Siniking sort, Exchange sort
//swapping with the next adjacent element if first elem is greater than second elem
//after first pass greatest elem is at end
//In second pass second largest element is from last to second place 
// It's like sorting from last to first
// As for each iteration last elements are sorted, so it doesn't matter if we compare those last sorted elements in j counter
// so to tackle this, we go till len - i - 1, so that we reduce some un necessary comparisions

//Space - O(1) - no extra space required i.e., no copying to array {In place sorting algorithim}
//Time 
    // best case - O(N) - sorted
    // worst cae - O(n^2) - sorted in reverse order

//Best case: if j never swap a value for i, it means array is sorted, so you can end the program 
    // If j doesn't swap any in i = 0, then it is swapped so for i = 0, iterating n - 1 elems {as j start from 1} -> so O(N)

// Bubble sort is Stable sorting algorithm - means the order is maintained i.e., the exact element is in the sorted array.


/**
 * BubbleSort
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 5,4,3,2,1};
        improvedBubble(arr);
        System.out.println(Arrays.toString(arr));
        
    }
    //improved version - added swapped boolean varible 
    static void improvedBubble(int[] arr){
        boolean swapped;
        //run the loop n - 1 times 
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            //for each step, max elem will come at last respective index
            for (int j = 1; j < arr.length - i; j++) {
                // compare 
                //swap if the elem is smaller than previous item
                if (arr[j] < arr[j - 1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            //one i iteration completed
            // If you didn't swapped for a particular value of i, it means array is sorted
            //so you can exit
            if (!swapped){ // !false = trues so swapped == false
                break;
            }
        }
    }


    //normal swap 
    static void bubble(int[] arr){
        //run the loop n - 1 times 
        for (int i = 0; i < arr.length; i++) {
            //for each step, max elem will come at last respective index
            for (int j = 1; j < arr.length - i; j++) {
                // compare 
                //swap if the elem is smaller than previous item
                if (arr[j] < arr[j - 1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}