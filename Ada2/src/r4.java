import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class r4 {
	//static int N=0;
	public static void main(String args[]) {
		try {
			
			Scanner sc = new Scanner(System.in); 
			  int T = sc.nextInt(); 
			  for (int j = 0; j< T; j++) { 
				  int M = sc.nextInt(); 
				  int N = sc.nextInt(); 
				  long arr[] = new long[M]; 
				  long arr2[] = new long[M]; 
				  long sum1=0;
				  long sum2=0;
				  for (int i = 0; i < M; i++) { 
					  arr[i] =sc.nextLong(); 
					  sum1+=arr[i];
					 
					  } 
				  for (int i = 0; i < M; i++) { 
					  arr2[i] = sc.nextLong(); 
					  sum2+=arr2[i];
				  }
				  
				  BigInteger n=calculatefib(sum1*M, sum2*M,  N);
				 // fib(sum1*M, sum2*M,  N);
					BigInteger x=new BigInteger("1000000007");
					System.out.println(n.mod(x));
				  }
			
 
		} catch (Exception e) {
			return;
		}
 
	}
 
	public static BigInteger calculatefib(long sum1,long sum2, int N) {
 
	
		BigInteger result=new BigInteger("0");
		
				BigInteger[] fib = new BigInteger[1+Math.max(2,N)];
				fib[0]=BigInteger.valueOf(sum1);
				fib[1]=BigInteger.valueOf(sum2);
				for(int k=2;k<N;k++) {
					fib[k] = fib[k - 1] .add(fib[k - 2]) ;
				}
				 result = result .add(fib[N-1]) ;
		
		return result;
		}
	

	    
	 
	   
	     
	
}
