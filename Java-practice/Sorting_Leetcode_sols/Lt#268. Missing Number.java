//268. Missing Number

class Solution {
    public int missingNumber(int[] arr) {
        //logic: as elemes are from 0 to N use cyclic sort - O(N) and then search in them for missing element
        int i = 0;
        while(i < arr.length){
            int correctIndex = arr[i];
            //arr[i] < arr.length - skip if the element is last elem i.e., can't swap with the right index as it is not found
            if (arr[i] < arr.length && arr[i] != arr[correctIndex]){
                //swap
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
            else{
                i++; 
            }
        }
        // System.out.println(Arrays.toString(arr));

        //loop through array and find the missing no.
        for ( i = 0; i < arr.length; i++){
            if (i != arr[i]){ //for elements less than 
                return i;
            }
        }
        //if nothing returns means every elem is present then the last elemwill not present so N
        return arr.length;
    }
}