//digit count in a number
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
	    int c=0;
	    while (n>0){
	        int rem = n%10;
	        if (rem == 5){
	           c++; 
	        } 
	        n/= 10;
	    }
	    System.out.println(c);
	}
}
