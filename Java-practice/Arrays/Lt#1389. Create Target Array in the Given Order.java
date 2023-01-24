//1389. Create Target Array in the Given Order

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> temp = new ArrayList<Integer>(nums.length);
        for (int i =0; i<nums.length; i++){
            temp.add(index[i],nums[i]);
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i<nums.length; i++){
            ans[i] = temp.get(i); 
        }
        return ans;
    }
}