public class Palindrome {
    public static void main(String[] args) {
        String s = new String();
        s = null;
        System.out.println(isPalindrome(s));
        
    }

    static boolean isPalindrome(String str){
        if (str == null || str.length() ==0){
            return true;
        }
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);
            if (start != end){
                return false;
            }
        }

        return true;
    }
}
