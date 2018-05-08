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


public class LECANDY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try {
			int T=Reader.nextInt();
			int j=0;
			while(j<T){
			int N = Reader.nextInt();
			int C= Reader.nextInt();
			int i=0;
			int sum=0;
			while(i<N){
				sum+=Reader.nextInt();
				i++;
				
			}
			if(sum<=C){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
			j++;
			}
			}catch (IOException e) {
				e.printStackTrace();
			}

	}

}
