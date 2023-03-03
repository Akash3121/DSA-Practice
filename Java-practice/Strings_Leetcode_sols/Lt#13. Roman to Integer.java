//13. Roman to Integer

#python
class Solution:
    def romanToInt(self, s: str) -> int:
        d = {"I": 1, "V":5, "X":10, "L":50,"C":100, "D":500,"M":1000}
        ans = 0
        for i in range(len(s)):
            if i+1 < len(s) and d[s[i]] < d[s[i+1]]:
                ans = ans - d[s[i]]
            else:
                ans += d[s[i]]
        return ans

//Java
class Solution {
    public int romanToInt(String s) {
        int ans = 0, num = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            switch(s.charAt(i)){
                case 'M' -> num = 1000;
                case 'D' -> num = 500;
                case 'C' -> num = 100;
                case 'L' -> num = 50;
                case 'X' -> num = 10;
                case 'V' -> num = 5;
                case 'I' -> num = 1;
            }
            if (num < prev){
                ans -= num;
            }else{
                ans += num;
            }
            prev = num;
        }
        return ans;
    }
}