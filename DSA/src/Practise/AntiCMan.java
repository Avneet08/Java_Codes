package Practise;
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
class SortArr{
	void merge(char[] arr, int l, int m, int r)
	{
	    // Find sizes of two subarrays to be merged
	    int n1 = m - l + 1;
	    int n2 = r - m;

	    /* Create temp arrays */
	    char L[] = new char [n1];
	    char R[] = new char [n2];

	    /*Copy data to temp arrays*/
	    for (int i=0; i<n1; ++i)
	        L[i] = arr[l + i];
	    for (int j=0; j<n2; ++j)
	        R[j] = arr[m + 1+ j];


	    /* Merge the temp arrays */

	    // Initial indexes of first and second subarrays
	    int i = 0, j = 0;

	    // Initial index of merged subarry array
	    int k = l;
	    while (i < n1 && j < n2)
	    {
	        if (L[i] <= R[j])
	        {
	            arr[k] = L[i];
	            i++;
	        }
	        else
	        {
	            arr[k] = R[j];
	            j++;
	        }
	        k++;
	    }

	    /* Copy remaining elements of L[] if any */
	    while (i < n1)
	    {
	        arr[k] = L[i];
	        i++;
	        k++;
	    }

	    /* Copy remaining elements of L[] if any */
	    while (j < n2)
	    {
	        arr[k] = R[j];
	        j++;
	        k++;
	    }
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(char arr[], int l, int r)
	{
	    if (l < r)
	    {
	        // Find the middle point
	        int m = (l+r)/2;

	        // Sort first and second halves
	        sort(arr, l, m);
	        sort(arr , m+1, r);

	        // Merge the sorted halves
	        merge(arr, l, m, r);
	    }
	}
}

public class AntiCMan {
public static void cman(char[] a,char[] b){
	
	for (int i=0;i<a.length-1;i++){
		
			
				if(a[i]==b[i] ){
					System.out.print(a[i]);
					i++;
				}
					else if (a[i]>b[i]){
						b[i]=b[i+1];
						//continue;
						
					}
					else if(a[i]<b[i]){
						a[i]=a[i+1];
					//continue;
					}
			
		}
	
	
	
	
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try {
			String a = null,b = null;
			int MAXN = Reader.nextInt();
			for (int i=0; i<MAXN; i++) {
				a=Reader.next();
				b=Reader.next();
				
				char[] charArray = a.toCharArray();
				char[] charArr = b.toCharArray();
				SortArr h=new SortArr();
				h.sort(charArray, 0, charArray.length-1);
				
				h.sort(charArr, 0, charArr.length-1);
				cman(charArray,charArr);
				System.out.println('\n');
			} 
			
			
		} 
	catch (IOException e) {
		e.printStackTrace();
	}

}
}
