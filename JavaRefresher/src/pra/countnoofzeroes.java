package pra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
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
public class countnoofzeroes {
	
int countzeroes(int arr[],int n){
	int count=0;
for(int i=0;i<n;i++){
	if(arr[i]==0){
		count++;
	}

}
return count;
}
	
	

public static void main(String[] args) {
	// TODO Auto-generated method stub
	Reader.init(System.in);
	try {
		countnoofzeroes b=new countnoofzeroes();
		
		int n=Reader.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
		arr[i]=Reader.nextInt();	
		}
		System.out.println(b.countzeroes(arr,n));
		
		}
	
	catch (IOException e) {
		e.printStackTrace();
	}
	/*int[] arr={1,1,1,0,0};
	int n=5;
	countnoofzeroes b=new countnoofzeroes();
	System.out.println(b.countzeroes(arr,n));*/
	
}
}
