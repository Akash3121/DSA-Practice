//1616. Split Two Strings to Make Palindrome

//Java
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return combine(a, b) || combine(b, a);
    }

    boolean combine(String a, String b){
        int i = 0, j = b.length() - 1;
        //skip the part that is same
        while (i < j && a.charAt(i) == b.charAt(j)){
            i++;
            j--;
        }
        return i >= j || isPalindrome(a.substring(i, j+1)) || isPalindrome(b.substring(i, j+1));
        //i>=j -> string will be palindrome if we cut half
    }

    boolean isPalindrome(String s){
        for (int i = 0, j = s.length() - 1; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}