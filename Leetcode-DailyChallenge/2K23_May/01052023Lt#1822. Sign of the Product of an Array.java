//1822. Sign of the Product of an Array

//Java
class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums){
            if (num == 0){
                return 0;
            } else if (num < 0){
                sign = -sign;
            }
        }

        return sign;
    }
  
}

//Java
class Solution {
    public int arraySign(int[] nums) {
        int product = 1;
        for(int i = 0; i < nums.length; i++){ // n times
            if (nums[i] > 0){
                product *= 1;
            } else if (nums[i] < 0){
                product *= -1;
            } else{
                product *= 0;
            }
        }
        return signFunc(product);
    }
    private int signFunc(int num){
        if (num > 0){
            return 1;
        } else if(num < 0){
            return -1;
        } 
        return 0;
    }
}