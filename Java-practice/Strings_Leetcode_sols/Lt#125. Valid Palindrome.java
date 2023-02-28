//125. Valid Palindrome

//Java
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;

        while (start <= end){
            //if not a character or digit then skip it
            if (!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(end))){
                end --;
            } else{ // both are characters 
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                    return false;
                }
                start ++;
                end --;
            }
        }
        
        return true;
    }
}

#python3
class Solution:
    def isPalindrome(self, s: str) -> bool:
        raw = ''.join(ch for ch in s if ch.isalnum()).lower()
        return raw[::-1] == raw