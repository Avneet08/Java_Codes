package src2;

import java.math.BigInteger;
import java.util.Scanner;

public class J_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			int T=sc.nextInt();
			for(int i=0;i<T;i++) {
				int n=sc.nextInt();
				int m=sc.nextInt();
				int[] arr=new int[n];
				int count=0;
				for(int j=0;j<n;j++) {
					arr[i]=sc.nextInt();
					if(arr[i]%m==0) {
						count++;
					}
					
				}
				long ans=0;
				ans+=(long) (Math.pow(2, count)-1);
				System.out.println(ans);
				
				
			}
		}
		catch(Exception e) {
			System.out.println("\n");
			System.out.println(e);
		}
	}

}
