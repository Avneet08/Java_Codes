package src2;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class july_2 {
	
	public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        BigInteger N = in.nextBigInteger().add(new BigInteger("1"));
        int k = in.nextInt();
        while(true)
        {
            String s = N.toString(2);
            int pos = -1,count1=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(s.length()-i-1)=='1')
                {
                    count1++;
                    if(pos==-1)
                        pos=i;
                }
            }
//            System.out.println(count1+" "+pos+" "+N);
            if(count1==k)
            {
                System.out.println(N);
                break;
            }
            else if(k-count1>0&&k-count1<=pos)
            {
                BigInteger a = BigInteger.ZERO;
                for(int i=0;i<k-count1;i++)
                {
                    a = a.multiply(new BigInteger("2")).add(BigInteger.ONE);
                }
                N = N.add(a);
                System.out.println(N);
                break;

            }
            else
            {
                N = N.add(BigInteger.valueOf((long)Math.pow(2,pos)));
            }

        }
    }
}
