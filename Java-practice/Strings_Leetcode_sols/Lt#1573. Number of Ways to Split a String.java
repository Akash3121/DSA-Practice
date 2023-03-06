//1573. Number of Ways to Split a String

//Java
class Solution {
    public int numWays(String s) {
        // Logic: count no.of ones in the string, if count of ones not divide by 3 then return 0
        // if ones is zero then nC2 {(n-1)*(n-2)/2} -> as all are zeroes we can put the cut any where
        // if ones is divisible by 3 the take oneThird = ones / 3

        long ones = 0;
        long n = s.length();
        long MOD = 1_000_000_007;

        //count the no.of ones
        for(char ch: s.toCharArray()){
            ones += ch - '0';
        }
        // if ones is zero then nC2 {(n-1)*(n-2)/2} -> as all are zeroes we can put the cut any where
        if (ones == 0){
            return (int)((((n-1)*(n-2))/2) % MOD);
        }
        //if count of ones not divide by 3 then return 0
        if (ones % 3 != 0){
            return 0;
        }

        long oneThird = ones / 3;
        ones = 0;
        long ways1 = 0;
        long ways2 = 0;

        for(char ch: s.toCharArray()){
            ones += ch - '0';
            if (ones == oneThird){
                ways1++;
            }
            if (ones == 2* oneThird){
                ways2++;
            }
        }

        return (int)((ways1* ways2)%MOD);        
    }
}