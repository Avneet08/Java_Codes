import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
public class lab2 {
	/*public static void cl2(ArrayList<Integer> Pi){
		int count=0;
		int i=0;
		int n= climb( Pi, i,count);
		System.out.println(n);
	}
	public static int climb(ArrayList<Integer> Pi,int i,int count){
		int count2=count;
		int c=Pi.size();
		int e=i;
		
		while(e<c){
			//System.out.println("bye");
			int d=e+Pi.get(e);
			if(d<=c && d>0 ){
				e=d;
				count2++;
			}
			
			
			else {
				//System.out.println("hi");
				e++;
				count2++;
			}
		}
		if(count2==c){ return -1;}
		else{
			//System.out.println(count2);
			return climb(Pi,e,count2);
		}
		 
	}*/

	public static void constructmatrix(ArrayList<Integer> Pi){
		int c=Pi.size();
		int matrix[][]=new int[c][c];
		for (int i=0;i<c;i++){
			for(int j=1;j<=c;j++){
				if(j==i+1){
			matrix[i][j]=1;}}
			
			
			//matrix[i][Pi.get(i)+i]=Pi.get(i)+i;
		}
		
		for(int i=0;i<c;i++){
			for(int j=0;j<c;j++){
				System.out.print(matrix[i][j] +" ");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Reader.init(System.in);
				// TODO Auto-generated method stub
						Reader.init(System.in);
						try {
							ArrayList<Integer> Pi=new ArrayList<Integer>();
							int T=Reader.nextInt();
							for(int i=0;i<T;i++){
								int S =Reader.nextInt();
								for(int j=0;j<S;j++){
									int P =Reader.nextInt();
									Pi.add(P);
								}
								constructmatrix(Pi);
							}
						}
						catch (IOException e) {
							e.printStackTrace();
						}
	}

}
