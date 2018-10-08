package src2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class C2 {
	
	    static int minPalPartion(String str)
	    {
	        int n = str.length();
	      
	        int[][] C = new int[n][n];
	        boolean[][] P = new boolean[n][n];
	       
	        int i, j, k, L; 
	        for (i = 0; i < n; i++)
	        {
	            P[i][i] = true;
	            C[i][i] = 0;
	        }
	       
	        for (L = 2; L <= n; L++)
	        {
	            for (i = 0; i < n - L + 1; i++)
	            {
	                j = i + L - 1; 
	                if (L == 2)
	                    P[i][j] = (str.charAt(i) == str.charAt(j));
	                else
	                    P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i+1][j-1];
	       
	                if (P[i][j] == true)
	                    C[i][j] = 0;
	                else
	                {
	                    C[i][j] = Integer.MAX_VALUE;
	                    for (k = i; k <= j - 1; k++)
	                        C[i][j] = Integer.min(C[i][j], 
	                                C[i][k] + C[k+1][j] + 1);
	                }
	            }
	        }for(int i2=0;i2<n;i2++) {
	        	for(int i3=0;i3<n;i3++) {
		        	System.out.print(" "+C[i2][i3]);
		        }
	        	System.out.println("\n");
	        }
	        return C[0][n-1];
	    }
    
	   
	    public static void main(String args[])
	    {
	       try {
	    	   Scanner sc = new Scanner(System.in);
	    	   String str=sc.next();
	    	   System.out.println(minPalPartion(str));
	       }
	       catch(Exception e) {
				System.out.println(e);
			}
	    }
	}

		