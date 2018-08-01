package src2;

import java.math.BigInteger;
import java.util.Scanner;

public class sahil_1 {
	static int countSetBits1(BigInteger n)
    { BigInteger a = new BigInteger("0");
    BigInteger one=new BigInteger("1");
        int count = 0;
        while (n .compareTo(a) ==1)
        { 
        	BigInteger y=n.subtract(one);
        	BigInteger x=n.and(y);
        	System.out.println(x);
        	n=n.add(x);
        	//System.out.println(n);
            //n &= (n.subtract(one)) ;
            count++;
        }
        return count;
    }
	public static int countSetBits(BigInteger n) {
		BigInteger a = new BigInteger("0");
	    BigInteger one=new BigInteger("1");
        // base case
        if (n .compareTo(a)==0)
            return 0;
        else
            return 1 + countSetBits(n .and (n.subtract(one)));
    }

		public static void main(String[] args) {
			
			
			try {
				Scanner r = new Scanner(System.in);
			
				BigInteger y=new BigInteger("0");
				y=r.nextBigInteger();
				System.out.println(countSetBits(y));
			
			
			}catch(Exception e) {
				System.out.println(e);
			}
		}

}
