//2405. Optimal Partition of String

//Java
class Solution {
    public int partitionString(String s) {
        int i = 0, ans = 1, flag = 0;
        while(i < s.length()) {
            int val = s.charAt(i) - 'a';
            if ((flag & (1 << val)) != 0) {
                flag = 0;
                ans++;
            }
            flag = flag | (1 << val);
            i++;
        }
        return ans;
    }
}

//Java
class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int res = 1;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (!set.add(ch)){
                res++;
                set.clear();
                set.add(ch);
            }
        } 
        return res;
    }
}