//1402. Reducing Dishes

#python3
class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        satisfaction.sort(reverse = True)
        n = len(satisfaction)

        presum, res = 0, 0
        for i in range(n):
            presum += satisfaction[i]
            if presum < 0:
                break
            res += presum
        return res

//Java
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;

        int presum = 0, sum = 0;

        for (int i = n - 1; i >= 0; i--){
            presum += satisfaction[i];

            if (presum < 0){
                break;
            }
            sum += presum;
        }
        return sum;
    }
}