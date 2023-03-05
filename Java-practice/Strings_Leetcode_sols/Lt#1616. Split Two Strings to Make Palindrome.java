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

//Go
func checkPalindromeFormation(a string, b string) bool {
    return combine(a, b) || combine(b, a);
}

func combine(a string, b string) bool{
    for low, high := 0, len(a)-1; low < high; low, high = low+1, high-1 {
		if a[low] != b[high] {
			return isPalindrome(a[low:high+1]) || isPalindrome(b[low:high+1])
		}
	}
	return true
}
   
func isPalindrome(s string) bool{
    for i, j := 0, len(s)-1 ;i < j; i,j = i+1, j-1{
        if (s[i] != s[j]){
            return false;
        }
    }
    return true;
}

