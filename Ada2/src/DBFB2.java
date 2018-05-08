import java.math.BigInteger;
import java.util.Scanner;

public class DBFB2 {
	static BigInteger l;
	static BigInteger c;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i =0;i<T;i++){
			int m = sc.nextInt();
			int n = sc.nextInt();
			long[] arr= new long[m]; 
			long[] arr2= new long[n]; 
			l =BigInteger.valueOf(0);
			c=BigInteger.valueOf(0);
			for(int u =0;u<m;u++){
				arr[u]=sc.nextInt();
				l = l.add(BigInteger.valueOf(arr[u]));
			}
			for(int u =0;u<m;u++){
				arr2[u]=sc.nextInt();
				c = c.add(BigInteger.valueOf(arr2[u]));
			}
			l = l.multiply(BigInteger.valueOf(m));
			c = c.multiply(BigInteger.valueOf(m));
			 BigInteger x=BigInteger.valueOf(1);
			  BigInteger y=BigInteger.valueOf(0);
			 
			  BigInteger q=l.add(c);
			  BigInteger F[][] = new BigInteger[][] { { x, x }, { x, y } };
				BigInteger P[][]=new BigInteger[][] { { q, c }, { c, l } };
				if (n == 1){
			    	System.out.println(l);
			    	continue;
			    }
			    else if(n == 2){
			       System.out.println(c);
			       continue;
			    }
			    else if(n ==3){
			    	System.out.println(q);
				       continue;
			    }
			    else{
			        power(F, n-3);
			        F[0][0]= (F[0][0].multiply((c.add(l)))).add(F[1][0].multiply(c));
			        BigInteger modm = BigInteger.valueOf(1000000007);
					System.out.println(F[0][0].mod(modm));
			    }
			//BigInteger output = fib(n);
			
		}

	}
	
	static BigInteger F[][];
	
      
    static BigInteger[][] multiply(BigInteger F[][], BigInteger M[][])
    {
    BigInteger x =  (F[0][0].multiply(M[0][0])).add(F[0][1].multiply(M[1][0]));
    BigInteger y =  (F[0][0].multiply(M[0][1])).add(F[0][1].multiply(M[1][1]));
    BigInteger z =  (F[1][0].multiply(M[0][0])).add(F[1][1].multiply(M[1][0]));
    BigInteger w =  (F[1][0].multiply(M[0][1])).add(F[1][1].multiply(M[1][1]));
     
    F[0][0] = x;
    F[0][1] = y;
    F[1][0] = z;
    F[1][1] = w;
    return F;
    }
      

    static void power(BigInteger F[][], int n){
    	if( n == 0 || n == 1)
    	      return;
    	BigInteger M[][] = new BigInteger[][]{{BigInteger.valueOf(1),BigInteger.valueOf(1)},{BigInteger.valueOf(1),BigInteger.valueOf(0)}};
    if(n == 1){
	      return;
    }
    power(F, n/2);
    multiply(F, F);
    if (n%2 != 0){
    	multiply(F, M);
    }
    }

	
}
