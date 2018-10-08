package src2;

import java.util.Scanner;

public class procon_3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			int t =sc.nextInt();
			for(int i=0;i<t;i++) {
				long n=sc.nextLong();
				long b=sc.nextLong();
				
				double x=n/(double)b;
				System.out.println(Math.ceil(x));
				

				
			}
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
