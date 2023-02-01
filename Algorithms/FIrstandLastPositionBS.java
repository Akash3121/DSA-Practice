//Lt#34. Find First and Last Position of Element in Sorted Array
//a = [2,7,7,7,7,8,8,9], target = 7
// then return 1,4 as array since 1 is 7 first index position and 4 is 7 last index position

public class App {
    public static void main(String[] args) throws Exception {
        int[] a = {2,7,7,7,7,8,8,10};
        int target = 7;
        System.out.println(searchRange(a, target));
    }
    
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = binarySearch(nums, target, true);
        if (ans[0] != -1){//if ans[0] is -1 means no element is there, then why we need to check for the last index
		ans[1] = binarySearch(nums, target, false) ;
        }
	return ans;
    }

    public static int binarySearch(int[] arr, int target, boolean firstIndex){
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (target > arr[mid]){
                start = mid + 1;
            }
            else if (target < arr[mid]){
                end = mid - 1;
            }
            else{
                ans = mid;
                if (firstIndex){// if checking first pos, then check before mid as already we are storing this mid as ans
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        
        return ans;
    }
}