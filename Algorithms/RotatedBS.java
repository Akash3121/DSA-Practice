//33. Search in Rotated Sorted Array
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class RotatedBS {
    public static void main(String[] args) {
        int[] a = {2,2,9,2,2,2,2};
        int target = 2;
        System.out.println(search(a, target));
        
    }
    
    static int search(int[] nums, int target){
        int pivot = (findPivotWithDuplicates(nums));
        //if you did not find a pivot it means the array is not rotated 
        if (pivot == -1){
            //just do not binary search
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        //ex:3,4,5,0,1,2 if target < last elem(2) then search in 2nd half array
        if (target >= nums[0]){
            return binarySearch(nums, target, 0, pivot);
        }
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }
    
    //3x: 3,4,5,0,1,2 - first find the pivot and then do the binary searchin 2 sorted arrays left and right
    //works only for distinct values, ex: 2,9,2,2,2 here in this case start, end, mid all are same so the last 2 cases in finding pivot will fail
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            //4 cases 
            //3,4,5,0,1,2 - here 5 is mid
            if (mid < end && arr[mid] > arr[mid + 1]){ //if mid is last elem, when checking the mid + 1, gives indexout of bounds, so add condition - mid < end
                return mid;
            }
            //3,4,5,0,1,2 - here 0 is mid
            if (mid > start && arr[mid] < arr[mid - 1]){ 
                return mid - 1;
            }
            //3,4,5,0,1,2 - elems 5,0 not be mid becouse if mid then they would catch in above e cases
            //ex: mid = 1 start = 3 the second array is always less than the first element
            if (arr[mid] <= arr[start]){
                end = mid - 1;
            }else { //ex: mid = 4 start = 3, so the left side of mid not needed
                start = mid + 1;
            }
        }
        return -1;
    }
    
    static int findPivotWithDuplicates(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            //4 cases 
            //3,4,5,0,1,2 - here 5 is mid
            if (mid < end && arr[mid] > arr[mid + 1]){ //if mid is last elem, when checking the mid + 1, gives indexout of bounds, so add condition - mid < end
                return mid;
            }
            //3,4,5,0,1,2 - here 0 is mid
            if (mid > start && arr[mid] < arr[mid - 1]){ 
                return mid - 1;
            }
            //if elements at start, end, mid are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]){
                //skip the duplicates
                //NOTE: what if these elements at start and end were pivots?
                // check if start is pivot
                if (arr[start] > arr[start + 1]){
                    return start;
                }
                start++;
                //check if end is pivot
                if (arr[end] < arr[end - 1]){
                    return end - 1;
                }
                end--;
            }
            //left side is sorted, so pivot should be in right side
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid]  && arr[mid] > arr[end])){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (target < arr[mid]){
                end = mid - 1;
            }else if (target > arr[mid]){
                start  = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }


}
