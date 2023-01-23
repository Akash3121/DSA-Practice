//checking a number whether a number is prime or not.
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
	    System.out.print(isPrime(n));
	}
	static boolean isPrime(int n){
	    if (n<=1){
	        return false;
	    }
	    
	    int c = 2;
	    while(c*c <= n){
	        if (n%c == 0){
	            return false;
	        }
	        c++;
	    }
	    return c*c >n;
	}
}
