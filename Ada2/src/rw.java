import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class rw {

	public static void main(String args[]) {
		try {
			Scanner sc = new Scanner(System.in);
			//int T = sc.nextInt();
			//for (int j = 0; j < T; j++) {
				int limit = sc.nextInt();
				Long arr[] = new Long[limit];
				for (int i = 0; i < limit; i++) {
					arr[i] = sc.nextLong();
				}
				Long C=generateseq(arr,arr.length);
				System.out.println(C);
				
				
				
				
			//}
		} catch (Exception e) {
			return;
		}
}
	

	public static long xoring(long xor,long c){
		return (xor^c);
		}
	public static Long generateseq(Long[] arr,int n) {
		//long[] B=new long[n*n];
		ArrayList<Long> matrix=new ArrayList<Long>();
		long Xor=0;
		for(int i=0;i<n;i++) {
			Long x=arr[i]+arr[i];
			matrix.add(x);
				Xor=xoring(Xor,x);
			}
		
		return Xor;
		
		
	}
}