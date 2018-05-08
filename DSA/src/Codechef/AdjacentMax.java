package Codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
        	
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}

public class AdjacentMax {
	int max(int a,int b){
		 if(a>b)return a;
		 else return b;
	 }
	void Median(int[] A,int n){
		int[] B=new int [n];
		for(int k=0;k<n;k++){
			System.out.print(A[k]+" ");
			System.out.print(A[2*n-1-k]+" ");
			int c=max(A[k], A[(2*n)-1-k]);
			B[k]=c;
			
		}
		System.out.println(" ");
		System.out.println(B[(n-1)/2]);
		
	}
	
	public static void main(String[] args) {
		
		/*Reader.init(System.in);
		try {
			int MAXN = Reader.nextInt();
			
			AdjacentMax b=new AdjacentMax();
			for (int i=0; i<MAXN; i++) {
				int n = Reader.nextInt();
				int A[]=new int[2*n];
				for (int j=0; j<2*n; i++) {
					int userin = Reader.nextInt();
					 A[j]=userin;
					 }
				b.Median(A, n);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}*/
		AdjacentMax b=new AdjacentMax();
		int A[]={1,2};
		b.Median(A, 1);
		
	}
}

