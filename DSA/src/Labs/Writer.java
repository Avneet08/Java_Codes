package Labs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Reader1 {
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

public class Writer {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader1.init(System.in);
		try {
			int length = Reader1.nextInt();
			int query = Reader1.nextInt();
			String Str = Reader1.next();
			String c="C";
			String t="T";
			String w="W";
			int leng=length;
			
			for (int i=0; i<query; i++) {
				 
				 String userin = Reader1.next();
					if (t.equals(userin)){
						String a=Reader1.next();
						Str=Str+a;
						leng=Str.length();
						
					}
					else if (c.equals(userin)){
					
					System.out.println(leng);
					} 
					else if(w.equals(userin)){
						int len = Reader1.nextInt();
						Str=Str.substring(0, (Str.length() - len));
						leng=Str.length();
						
						
						
						
					}
			}
			
		}
			
		catch (IOException e) {
			e.printStackTrace();
		}
		/*Writer b=new Writer();
		String Str="ab9";
		String T="raw";
		Str=Str+T;
		b.Count(Str);
		int W=5;
		Str=Str.substring(0, (Str.length() - W));
		b.Count(Str);*/
		
	}
}
