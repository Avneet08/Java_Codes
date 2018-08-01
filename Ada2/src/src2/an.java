package src2;

import java.math.BigInteger;
import java.util.Scanner;

public class an {
	
	 public static void main(String[] args){
	     Scanner in=new Scanner(System.in);
	     int n=in.nextInt();
	     int k=in.nextInt();
	     BigInteger s=new BigInteger("2");
	     BigInteger q=new BigInteger("0");
	     BigInteger p=new BigInteger("0");  BigInteger op=new BigInteger("0");
	     if(n%2==0) {
	    	 p=(s.pow(n/2));
	    	 p=p.add(BigInteger.valueOf(1));
	     }
	     else {
	    	 p=(s.pow(((n-1)/2)));
	    	// System.out.println();
	    	 p=p.add(BigInteger.valueOf(1));
	     }
	     
	    		 q=s.pow(n-1);
	    		 System.out.println(p);
	    		 op=q.subtract(p);
	    		
	    		 BigInteger c=new BigInteger("1000000007");
	    		 BigInteger r =op.mod(c);
	    		 BigInteger d=q.modInverse(c);
	    		 BigInteger e=d.mod(c);
	    		 BigInteger f=(r.multiply(e)).mod(c);
	    		 System.out.println(f);
	    		 
	    		   
	    		  
	    		  
	    		  
}
}