//2390. Removing Stars From a String

# python3
class Solution:
    def removeStars(self, s: str) -> str:
        ans = []
        for i in s:
            if i == '*':
                ans.pop()
            else:
                ans += [i]
        return "".join(ans)

//Java
class Solution {
    public String removeStars(String s) {
        StringBuilder c = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '*'){
                c.deleteCharAt(c.length() - 1);
            } else{
                c.append(s.charAt(i));
            }
        }
        return c.toString();
    }
}