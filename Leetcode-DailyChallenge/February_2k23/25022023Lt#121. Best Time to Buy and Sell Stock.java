//121. Best Time to Buy and Sell Stock
#python3
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        left = 0
        right = 1
        max_profit = 0
        while right < len(prices):
            current_profit = prices[right] - prices[left]

            if prices[left] < prices[right]:
                max_profit = max (current_profit, max_profit)
            else:
                left = right
            right += 1
        return max_profit

//Javascript
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let left = 0;
    let right = 1;
    let max_profit = 0;

    while (right < prices.length){
        if (prices[left] < prices[right]){
            currProfit = prices[right] - prices[left];
            max_profit = Math.max(currProfit, max_profit);
        } else{
            left = right;
        }
        right ++;
    }

    return max_profit;
    
};