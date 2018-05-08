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


public class University {
	void maxpre(int N,int[] A){
		int count=0;
		int i=1;
			for(int j=1;j<=A.length;j++){
				if(A[j-1]==i){
					i++;
				}else{
					count++;
				}
			}
			System.out.println(count);

		}
		
	
	public static void main(String[] args) {
		
		/*Reader.init(System.in);
		try {
			int MAXN = Reader.nextInt();
			
			University b=new University();
			for (int i=0; i<MAXN; i++) {
				int N = Reader.nextInt();
				int[] A=new int[N];
				for(int j=0;j<N;j++){
					int userin = Reader.nextInt();
					A[j]=userin;	
				}
				b.maxpre(N, A);
			}
}
		catch (IOException e) {
			e.printStackTrace();
		}*/
		University b=new University();
	int A[]={0,1,2};
	b.maxpre(14, A);
		
		
	}
}
