package myProject;

import java.util.Scanner;

public class Patterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan2=new Scanner(System.in);
		System.out.println("Enter some int num");
		int no=scan2.nextInt();
		for(int i=0;i<=no;i++){
			for(int j =0;j<=i;j++){
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

}
