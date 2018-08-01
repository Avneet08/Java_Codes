package src2;

import java.math.BigInteger;
import java.util.Scanner;

public class J_1 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			int T=sc.nextInt();
			for(int i=0;i<T;i++) {
				int n=sc.nextInt();
				
				BigInteger z=new BigInteger("0");
				BigInteger o=new BigInteger("10");
				if(n%2==0) {
				
				z=o.pow(n/2);
				}
				else {
					
					z=o.pow((n-1)/2);
				}
				
				
				System.out.println(1+" "+z);
				
				
			}
		}
		catch(Exception e) {
			System.out.println("\n");
			System.out.println(e);
		}
	}

}
