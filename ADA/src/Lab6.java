import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lab6 {
		 
 static int maxSub(int a[],int[] copy,int[] b) {
	 int sum=0;
	 for(int i=0;i<a.length;i++) {
		sum=a[i]*(i+1);
		System.out.println(a[i]+" "+sum);
	 }
	 return sum;
 }
 static int first(int arr[], int low, int high, int x, int n)
 {
     if(high >= low)
     {
         int mid = low + (high - low)/2;
         if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
             return mid;
         else if(x > arr[mid])
             return first(arr, (mid + 1), high, x, n);
         else
             return first(arr, low, (mid -1), x, n);
     }
     return -1;
 }
  
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*Reader.init(System.in);
		int T=Reader.nextInt();
		for(int i=0;i<T;i++) {
			int N =Reader.nextInt();
			
			int[] Authors=new int[N];
			int[] Est_Time=new int[N];
			int[] copy=new int[N];
			for(int j=0;j<N;j++) {
				Authors[i]=Reader.nextInt();
				Est_Time[i]=Reader.nextInt();
				
			}
			int size = Est_Time.length;
			System.out.println(Arrays.toString(Authors));
			Arrays.sort(Est_Time);
			System.out.println(Arrays.toString(Est_Time));
			
	       //System.out.println(maxSub(Est_Time,Authors,copy));*/
		int arr[] = new int[] {3,2,4};
		int copy[] = new int[] {3,2,4};
		int Authors[] = new int[] {2,1,2};
		
        int size = arr.length;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++) {
        	if(first(copy,0,copy.length,arr[i],copy.length)!=-1) {
        	
        	}
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