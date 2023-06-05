//1456. Maximum Number of Vowels in a Substring of Given Length

//Java
class Solution {
    //TC: k+n-k = n times => O(N)
    //SC: O(1)
    private boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0;
        int i = 0;
        for (;i < k; i++){ //k times
            if(isVowel(s.charAt(i))){ //First window of size k
                count++;
            }
        }
        int ans = count;

        for (;i < n; i++){ //n-k times
            if(isVowel(s.charAt(i))){ //If new char is vowel increment count
                count++;
            }
            if(isVowel(s.charAt(i-k))){ //If previous character is vowel then decrement count
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}

//Java
class Solution {
    //TC: k+n-k = n times => O(N)
    //SC: O(1)
    private int isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return 1;
        }
        return 0;
    }
    public int maxVowels(String s, int k) {
        int max_vow = 0, curr_vow = 0;
        for(int i = 0; i < s.length(); i++){
            curr_vow += isVowel(s.charAt(i));
            if(i >= k){
                curr_vow -= isVowel(s.charAt(i - k));
            }
            max_vow = Math.max(max_vow, curr_vow);
        }
        return max_vow;
    }
}