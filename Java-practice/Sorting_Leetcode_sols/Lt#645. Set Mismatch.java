//645. Set Mismatch

class Solution {
    public int[] findErrorNums(int[] nums) {
        // logic: use cyclic sort as 1 to n and return elem at index and element expected to be at index i.e., correct elem
        //ans = what it is there, what it should be
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1; //index = value - 1
            if (i != correct && nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else{
                i++;
            }
        }

        // loop through and check for the elems needed
        
        for(i = 0; i < nums.length; i++){
            if (i != nums[i] - 1){
                return new int[] {nums[i], i + 1};
            }
        }

        return new int[] {-1, -1};
    }
}