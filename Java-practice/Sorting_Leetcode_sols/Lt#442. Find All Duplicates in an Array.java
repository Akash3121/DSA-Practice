//442. Find All Duplicates in an Array

//Java
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // Logic: use cyclic sort as 1 to N and then return elements which are not in their correct position
        int i = 0;
        while (i < nums.length){
            int correct = nums[i] - 1; //index = val - 1
            if (i != correct &&  nums[correct] != nums[i]){
                // swap
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else {
                i++;
            }
        }
        
        //loop the array and then which are not at correct index are appeared twice
        List<Integer> ans = new ArrayList<>();
        for(i = 0; i < nums.length; i++){
            if (i != nums[i] - 1){
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}