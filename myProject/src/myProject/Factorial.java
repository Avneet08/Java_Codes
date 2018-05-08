package myProject;
import java.util.Scanner;
public class Factorial {
	
	public static void main(String[] args) {
		int fact = 1;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter some int num");
		int num=scan.nextInt();
		
		for(int i=1 ; i<=num ;i++){
			fact = fact *i;
		}
		System.out.println("the fact of the no is "+num+" is "+fact);
	}

}
