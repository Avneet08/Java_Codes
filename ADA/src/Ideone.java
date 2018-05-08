import java.util.*;
import java.lang.*;
import java.util.*;
import java.util.Arrays;
import java.lang.*;
import java.io.*;
public class Ideone
{

	static int diff = 0;
    static long[] dp;
    static long minVal = Long.MAX_VALUE;

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int p = sc.nextInt();
            int q = sc.nextInt();

            long[] macho= new long[p];
            long[] nonmacho = new long[q];

            int r = 0;
            while (r < p) {
            	macho[r] = sc.nextLong();
                r++;
            }
            r = 0;
            while (r < q) {
            	nonmacho[r] = sc.nextLong();
                r++;
            }

            Arrays.sort(nonmacho);
            Arrays.sort(macho);
            diff = q - p + 1;
            dp = new long[diff];
            int i = nonmacho.length - 1;
            int j = diff - 1;
            while (i >= nonmacho.length - diff) {
                long heightDiff = abs(macho[macho.length - 1] - nonmacho[i]);
                if (heightDiff < minVal) {
                    minVal = heightDiff;
                }
                dp[j] = minVal;
                i--;
                j--;
            }
            i = macho.length - 2;
            while (i >= 0) {
                long[] tmp = new long[diff];
                long tallpeople = macho[i];
                minVal = Long.MAX_VALUE;
                j = diff - 1;
                while (j >= 0) {
                    long smallpeople = nonmacho[i + j];
                    long sumofdiff = abs(smallpeople - tallpeople) + dp[j];
                    if (sumofdiff > minVal) {

                    } else {
                        minVal = sumofdiff;
                    }
                    tmp[j] = minVal;
                    j--;
                }
                dp = tmp;
                i--;
            }
            System.out.println(minVal);
        } catch (Exception e) {
            return;
        }
    }

    private static long abs(long i) {
        // TODO Auto-generated method stub
        if (i < 0) {
            return -i;
        }
        return i;
    }
    }

    
