import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class r3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int j = 0; j < T; j++) {
			int limit = sc.nextInt();
			int k=sc.nextInt();
			ArrayList<Integer> seq=new ArrayList<Integer>();
			ArrayList<Integer> motu=new ArrayList<Integer>();
			ArrayList<Integer> tomu=new ArrayList<Integer>();
			for (int i = 0; i < limit; i++) {
				int x=sc.nextInt();
				seq.add(x) ;
				if(i%2==0) {
					motu.add(x);
				}
				else {
					tomu.add(x);
				}
			}
			
			Collections.sort(motu);
			Collections.sort(tomu);
			int i;
			int[] motu2=new int[motu.size()];
			int[] tomu2=new int[tomu.size()];
			for(int j1=0;j1<motu.size();j1++) {
				motu2[j1]=motu.get(j1);
			}
			for(int j1=0;j1<tomu.size();j1++) {
				tomu2[j1]=tomu.get(j1);
			}
			
			long sum1 = sumarray(motu2);
			long sum2=sumarray(tomu2);
			if(sum2 > sum1){
				System.out.println("YES");
			}
			else{
				if(k>Math.min(tomu.size(),motu.size())){
					k = Math.min(tomu.size(),motu.size());
				}
				performSwaps(motu2,tomu2,k);
				}
				
			}
			
		}
			
			
		
	private static void performSwaps(int [] motu2,int [] tomu2,int k) {
		
		int temp =0;
		int u=0;
		while(u<k) {
				temp = tomu2[u];
				tomu2[u] = motu2[motu2.length-1-u];
				motu2[motu2.length-1-u] = temp;
				u++;
		}
		long sum1 = sumarray(motu2);
		 long sum2=sumarray(tomu2);
		if(check(sum2,sum1)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}



	private static long sumarray(int[] arr) {
		long sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		return sum;
	}
	private static boolean check(long sumTomu, long sumMotu) {
		if(sumTomu > sumMotu){
			return true;
		}
		else{
			return false;
		}
		
	}

	
}
