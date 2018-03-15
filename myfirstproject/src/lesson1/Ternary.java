package lesson1;

import java.util.Scanner;

public class Ternary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// user enters two nos and we will use terenary operator to find max and min
		Scanner num=new Scanner(System.in);
		System.out.print("enter the value of num1: ");
		int num1=num.nextInt();
		System.out.print("enter the value of num2: ");
		int num2=num.nextInt();
		int min,max;
		min=(num1<num2)? num1:num2;
		max=(num1>num2)? num1:num2;
		System.out.println("the min is"+ min);
		System.out.println("the max is"+ max);
	}

}
