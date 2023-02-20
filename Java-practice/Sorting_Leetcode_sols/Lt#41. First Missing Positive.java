//41. First Missing Positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        // Logic: trigger cyclic sort as they mentioned O(n) time
        // Note: skip negative elements -> in question asked only missing positive integer

        // start from 1 and then check which is missing if 1 is not there then 1 is the ans
        // Ignore the elements that are negative and greater than n(length)
        
        // use 1 to N cycclic sort

        int i = 0;
        while (i < nums.length){
            int correct = nums[i] - 1; //index = value - 1 {1 to N}
            //positive only swap -> nums[0] > 0
            //what if we go to last elem i.e., elem length, we can't do that right so -> nums[i] < nums.length

            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else{
                i++;
            }
        }

        //loop and check 
        for(i = 0; i < nums.length; i++){
            if (i != nums[i] - 1){ //index = value - 1
                return i+1; //correct number is missing number
            }
        }

        return nums.length + 1; //if all are positive and are correct then the last elem is array length + 1 the next element because 1 to N not the 0 to N
    }
}