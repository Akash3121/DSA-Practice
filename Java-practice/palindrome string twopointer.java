/* check for a palindrome, as converted to string and used two - pointer
*/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String k = Integer.toString(n);
		System.out.print(isPalindrome(k));
	}
	
	static boolean isPalindrome(String n){
	  
	    int l = n.length();
	    for (int i = 0; i<l/2;i++ ){
	        if (n.charAt(i) != n.charAt(l-i-1))
	            return false;
	    }
	    return true;
	}
}




