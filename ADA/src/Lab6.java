import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Lab6 {
	 static int[][] dp;
    
	    static void printSubsetsRec(int arr[], int i, int sum, 
	                                         ArrayList<Integer> p,int count)
	    {
	    	if(count>1) {
	    		System.out.println("Ambiguous");
	    	}
	        if (i == 0 && sum != 0 && dp[0][sum]==0)
	        {
	            p.add(arr[i]);
	            System.out.println(p);
	            p.clear();
	            return;
	        }
	        if (i == 0 && sum == 0)
	        {
	        	System.out.println(p);
	            p.clear();
	            return;
	        }
	        if (dp[i-1][sum]==0)
	        {
	            // Create a new vector to store path
	            ArrayList<Integer> b = new ArrayList<>();
	            b.addAll(p);
	            printSubsetsRec(arr, i-1, sum, b,count++);
	        }
	      
	        // If given sum can be achieved after considering
	        // current element.
	        if (sum >= arr[i] && dp[i-1][sum-arr[i]]==0)
	        {
	            p.add(arr[i]);
	            printSubsetsRec(arr, i-1, sum-arr[i], p,count++);
	        }
	    }
	      
	    
	     
 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int T=Reader.nextInt();
		for(int i=0;i<T;i++) {
			int N=Reader.nextInt();
			int K=Reader.nextInt();
			int[] arr =new int[N];
			for(int j=0;j<N;j++) {
				arr[j]=Reader.nextInt();
			}
			int n=arr.length;
			 if (n == 0 || K < 0)
		           return;
		      
		        // Sum 0 can always be achieved with 0 elements
		        dp = new int[n][K + 1];
		        for (int j=0; i<n; ++i)
		        {
		            dp[j][0] = 0;  
		        }
		      
		        if (arr[0] <= K)
		           dp[0][arr[0]] = 0;
		      
		        for (int k = 1; i < n; ++i)
		            for (int j = 0; j < K + 1; ++j) {
		            	if(dp[k-1][j] ==0||dp[k-1][j-arr[k]]==0) {
		            		dp[k][j] = (arr[k] <= j)
		            	}
		            	dp[k][j] = (arr[k] <= j) ? (dp[k-1][j] ||dp[k-1][j-arr[k]]): dp[k - 1][j];}
		        if (dp[n-1][K] == -1)
		        {
		            System.out.println("Not possible");
		            return;
		        }
		      
		        ArrayList<Integer> p = new ArrayList<>();
		        printSubsetsRec(arr, n-1, K, p,0);
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