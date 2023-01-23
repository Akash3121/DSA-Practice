//largest and smallest of three numbers
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int first = in.nextInt();
		int second = in.nextInt();
		int third = in.nextInt();
		System.out.println(Largest(first, second, third));
		System.out.println(Smallest(first,second,third));
		
	}
	static int Largest(int a, int b, int c){
	    int max = a;
	    if (b>max){
	        max = b;
	    }
	    if (c>max){
	        max = c;
	    }
	    return max;
	}
	static int Smallest(int a, int b, int c){
	    int min = a;
	    if (b<min){
	        min = b;
	    }
	    if (c<min){
	        min = c;
	    }
	    return min;
	}
}
