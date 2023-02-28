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