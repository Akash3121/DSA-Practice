//1929. Concatenation of Array
//python
class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        return nums*2

//java
class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        for (int i = 0; i<nums.length;i++){
            ans[i]=nums[i];
            ans[i+nums.length]=nums[i];
        }
        return ans;
    }
}