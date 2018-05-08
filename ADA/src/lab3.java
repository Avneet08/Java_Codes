import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lab3 {
	 static int preferredlandlord(int Pref[][],int lndlrd,int tnt1,int lndlrd2,int N){
		
				int j=0;
				while(j<N){
					if(Pref[tnt1][j]==lndlrd){
						return 1;
					}
					else if(Pref[tnt1][j]==lndlrd2){
						return 0;
					}
				}

			
		
		return 1;
	}
	 static void findoptarg(int Pref[][],int finallndr[],boolean availability[],int N){
		 
		 int o=N;
		 for(int i=N-1;i>=0;i--){
			for(int j=0;j<N;j++){
				if(availability[j]==false)
					break;
			}
			
			for(int k=0;k<N && !availability[i];k++){
				
				int w=Pref[i][k];

				System.out.println(w+" "+N);
				if (finallndr[w-N] == -1)
	            {
					finallndr[w-N] = i;
					availability[i] = true;
					
	                continue;
	            }
				else{
					int m1=finallndr[w-N];
					if(preferredlandlord(Pref,i,w,m1,N)==0){
						finallndr[w-N] = i;
						availability[i] = true;
						availability[m1] = false;
				}
			 
		 }
		 
			
			}
			
		 }
		                   
		printsol( finallndr, N); 
	 }

 static void printsol(int[] finallnrd,int N) {
		for(int i=0;i<N;i++){
			System.out.print(i+N+" "+finallnrd[i]);
		}
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int T=Reader.nextInt();
		for (int i=0;i<T;i++){
			int N = Reader.nextInt();
			//int[][] Pref=new int[2*N][N];
			int [][] p1=new int[N][N];
			int [][] p2=new int[N][N];
			for(int j=0;j<N;j++){
				int m=Reader.nextInt();
				for(int k=0;k<N;k++){
					
					p1[m-1][k]=Reader.nextInt();
				}
			}
			for(int p=0;p<N;p++){
				int m=Reader.nextInt();
				for(int k=0;k<N;k++){
					
					p2[m-1][k]=Reader.nextInt();
				}
			}
			int m[][] = Arrays.copyOf(p1, p1.length + p2.length);
			System.arraycopy(p2, 0, m, p1.length, p2.length);
			boolean availability[]=new boolean[N];
			int[] finallndr=new int[N];
			for(int k=0;i<N;i++){
				finallndr[k]=-1;
			}
			findoptarg(m,finallndr,availability,N);
			
			
			
/*for(int j=0;j<2*N;j++){
				
				for(int k=0;k<N;k++){
					System.out.print(m[j][k]);
				}
			}*/
		}
	}

}
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