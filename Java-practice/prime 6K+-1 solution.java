//program to check prime number, 6K+-1 solution

/* all primes are set into the equation of 6K+-1, 
i.e., 6k+0, 6k+1, 6k+2, 6k+3, 6k+4, 6k+5 -> in these 6k+0, 6k+2, 6k+4 are divided by 2, 
lly 6k+3 is divided by 3, => so 6k+1, 6k+5 are left if we iterate and check these, that's it problem solved.
here the 6k+5 is 6k-1, so we need to check for 6k-1 and 6k+1.
O(root n) complexity
*/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.print(isPrime(n));
	}
	static boolean isPrime(int n){
	    if (n<=1)
	        return false;
	    if (n<=3)
	        return true;
	    if (n%2 == 0 || n%3 ==0)
	        return false;
	   for (int i = 6; i * i <= n; i += 6){
	       if (n%(i-1) == 0 || n%(i+1) == 0)
	            return false;
	   }
	    return true;
	}
}
