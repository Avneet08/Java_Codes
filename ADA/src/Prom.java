import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prom {
	static int compare(int []women,int x) {
		 int low = 0;
		    int high = women.length - 1;

		    if (high < 0)
		        return -1;

		    while (low < high) {
		        int mid = (low + high) / 2;
		        assert(mid < high);
		        int d1 = Math.abs(women[mid  ] - x);
		        int d2 = Math.abs(women[mid+1] - x);
		        if (d2 <= d1)
		        {
		            low = mid+1;
		        }
		        else
		        {
		            high = mid;
		        }
		    }
		     
		     return high;
	}
	static int FindPair(int[] men ,int[] women) {
		int dif=0;
		int pos=0;
		
		/*for(int i=0;i<men.length;i++) {
		int min=Integer.MAX_VALUE;
		for(int j=pos;j<=women.length-men.length+i;j++){
			
			if(Math.abs(men[i]-women[j]) < min){
				min=Math.abs(men[i]-women[j]);
				pos=j;
			}
			
			else{
				break;
			}
		}
		pos++;
		diff+=min;
		
		}*/
		for(int i=0;i<men.length;i++) {
		int min=0;
		
			
			if(women[compare(women,men[i])]!=-1){
				//System.out.println(men[i]-women[compare(women,men[i])]);
				min=Math.abs(men[i]-women[compare(women,men[i])]);
				//System.out.println(min);
				pos=compare(women,men[i]);
			}
			
			else{
				break;
			}
			dif=dif+min;
		pos++;
		//System.out.println(min);
		
		//System.out.println(diff);
		}
		
		
		return dif;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int p=Reader.nextInt();
		int q=Reader.nextInt();
		int[] men =new int[p];
		int[] women =new int[q];
		for (int i=0;i<p;i++) {
			men[i]=(Reader.nextInt());
		}
		for (int i=0;i<q;i++) {
			women[i]=(Reader.nextInt());
		}
		Arrays.sort(men);Arrays.sort(women);
		System.out.println(FindPair(men,women));;
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