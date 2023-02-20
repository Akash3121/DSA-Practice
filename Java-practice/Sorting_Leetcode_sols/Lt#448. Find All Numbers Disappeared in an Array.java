//448. Find All Numbers Disappeared in an Array

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Logic: apply cyclic sort and then run through the loop insert into answers array 
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while ( i < nums.length){
            int correctIndex = nums[i] - 1;
            if ( i != correctIndex && nums[i] != nums[correctIndex]){ //inde = val - 1 => i!= correctIndex
            //but nums[i] != nums[correctIndex] is for we have duplicate elements if already correct elem is at correct pos and then we swap then it will be infinite loop
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else{
                i++;
            }
        }
        //now the array is sorted in O(N) time

        for (i = 0; i < nums.length; i++){
            if (i != nums[i] - 1){
                ans.add(i+1); //i+1 because i is index and i+1 is the elem
            }
        }
        return ans;
    }
}

#python
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # logic: put elements from 1 to n in set and then remove the given set 
        return set(range(1, len(nums)+1)) - set(nums)