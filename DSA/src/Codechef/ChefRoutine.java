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


 class ChefRoutine {
	void check(String ar){
		for(int i = 0, n = ar.length() ; i < n ; i++) { 
			if(i<ar.length()-1){
		    char c = ar.charAt(i); 
		   char d=ar.charAt(i+1);
		 
		   if(c=='C' || c=='E' && d=='E' ||d=='S' || c =='C' && d=='C' || c=='S'&& d=='S'){
			   
			continue;
		   }else{
			   
			   System.out.println("no");
			  break;
		   }
		  }
			 System.out.println("yes");
		}
	}
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ChefRoutine b=new ChefRoutine();
		Reader.init(System.in);
		try {
			int MAXN = Reader.nextInt();
			
			ChefRoutine b=new ChefRoutine();
			for (int i=0; i<MAXN; i++) {
				String task=Reader.next();
				b.check(task);
			}
}
		catch (IOException e) {
			e.printStackTrace();
		}
		/*String ar="EEEECEEEEEEEEE";
		b.check(ar);*/
		
	}
}
