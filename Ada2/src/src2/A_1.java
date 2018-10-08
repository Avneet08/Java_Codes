package src2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class A_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			int n=sc.nextInt();
		BigInteger[] arr=new BigInteger[n];
		BigInteger[] ans=new BigInteger[n];
		
		BigInteger min=new BigInteger("0");
			
			for(int i=0;i<n;i++) {
				BigInteger ai=new BigInteger("0");
				ai=sc.nextBigInteger();
				arr[i]=ai;
				if(i==0) {
					
					ans[0]=ai;
					
				}else{
					if(arr[i].compareTo(arr[i-1])==1 || arr[i].compareTo(arr[i-1])==0 ) {
						ans[i]=arr[i-1];
						if(min.compareTo(BigInteger.valueOf(0))==0) {
							min=arr[i-1];
						}
						if(arr[i-1].compareTo(min)==-1) {
							min=arr[i-1];
						}
						
					}
					else {
						ans[i]=min;
					}
				}
				
			}
			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(ans));
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
