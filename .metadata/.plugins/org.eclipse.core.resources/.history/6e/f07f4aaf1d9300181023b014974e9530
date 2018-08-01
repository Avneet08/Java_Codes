package src2;

import java.math.BigInteger;
import java.util.Scanner;

public class july_1 {
	private static BigInteger calc(BigInteger n) {
   	 BigInteger a = new BigInteger("0");
   	 BigInteger one=new BigInteger("1");
   	  String binary = n.subtract(one).toString(2);
   	  String reverse = new StringBuilder(binary).reverse().toString();
   	  System.out.println(binary+" "+reverse);
   	  int i=0;
   	  while(i<reverse.length()) {
   	  
   	    if(reverse.charAt(i) == '1') {
   	    	a = a.add(BigInteger.valueOf(3).pow(i));
   	    }
   	    i++;
   	  }
   	  return a;
   	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			Scanner sc = new Scanner(System.in);
		//int n=sc.nextInt();
			BigInteger n=new BigInteger("0");
			n=sc.nextBigInteger();
		BigInteger x =calc(n);
		System.out.println(x);
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
