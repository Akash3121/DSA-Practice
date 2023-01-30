//1295. Find Numbers with Even Number of Digits

//python
class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        return sum(len(str(n)) % 2 == 0 for n in nums)

//java
class Solution {
    public int findNumbers(int[] nums) {
        int c = 0;
        for (int i = 0; i< nums.length; i++){
            int e = 0;
            while(nums[i]>0){
                nums[i]/=10;
                e++;
            }
            if (e%2 == 0)
                c++;
        }
        return c;
    }
}