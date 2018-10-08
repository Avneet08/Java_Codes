package src2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class C1 {
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			int T=sc.nextInt();
			for(int i=0;i<T;i++) {
				int sum=0;
				int count=0;
				int n=sc.nextInt();
				int b=sc.nextInt();
				int[] input=new int[n];
				for(int j=0;j<n;j++) {
					input[j]=sc.nextInt();
			}
				//System.out.println(Arrays.toString(input));
				Arrays.sort(input);
				//System.out.println(Arrays.toString(input));
				for(int j=0;j<input.length;j++) {
					//System.out.println(input[j]);
					if(b>=input[j]) {
						//System.out.println(input[j]);
						count++;
						b=b-input[j];
						//System.out.println(b);
						
						//System.out.println(b);
						
					}
				}
				System.out.println( (count));
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
			
		
	}

}
