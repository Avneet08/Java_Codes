package src2;

import java.math.BigInteger;
import java.util.Scanner;
import java.math.*;
import java.util.*;
import java.lang.*;

public class sahil2_2 {
	private static int[] count(String s) {
		int pos = -1,count1=0,pos2=0;
		int i=0;
        while(i<s.length())
        {
            if(s.charAt(s.length()-i-1)=='1')
            {
                count1++;
                if(pos==-1)
                    pos=i;
            }
            else {
            	pos2=i;
            }
            ;i++;
        }
        int arr[]=new int[2];
        arr[0]=pos;
        arr[1]=count1;
		return arr;
	}
	public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        BigInteger N = in.nextBigInteger().add(new BigInteger("1"));
        int k = in.nextInt();
        while(true)
        {
            String s = N.toString(2);
            int arr[]=count(s);
            

            
            if(arr[1]!=k) {
             if(k-arr[1]>0) {
            	if(k-arr[1]<=arr[0]){
            
                BigInteger a = BigInteger.ZERO;
                int i=0;
                while(i<k-arr[1])
                {
                    a = a.multiply(new BigInteger("2"));
                    a=a.add(BigInteger.ONE);
                    i++;
                }
                N = N.add(a);
                System.out.println(N);
                break;

            }
            }
            else
            {
            	BigInteger r=BigInteger.valueOf((long)Math.pow(2,arr[0]));
                N = N.add(r);
            }
            }
            else
            {
                System.out.println(N);
                break;
            }

        }
    }

}
