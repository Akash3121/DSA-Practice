//checking for an armstrong number 
//printing all three 3 digit armstrong numbers 
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	//	int n = in.nextInt();
		for (int i = 100; i< 999; i++){
		    if(isArmstrong(i)){
		        System.out.print(i + " ");
		    }
		}
	//  System.out.print(isArmstrong(n));
	}
	static boolean isArmstrong(int n){
	    int original = n;
	    int sum =0;
	    while (n>0){
	        int rem = n%10;
	        n/=10;
	        sum += rem*rem*rem;
	    }
	    return sum == original;
	}
}
