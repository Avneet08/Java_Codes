package src2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class j_3 {
	
	 public static  int ycalc(StringBuilder s){
	        int y=0;
	         for(int j=0;j<s.length()-1;j++){
	             for(int k=j+1;k<s.length();k++){
	                 if(s.charAt(k)>s.charAt(j))
	                     y++;
	             }
	         }
	         return y;
	     }
	    public static void main(String[] args){
	     Scanner in=new Scanner(System.in);   
	     int t=in.nextInt();
	     for(int i=0;i<t;i++){
	         String s=in.next();
	         int y=0;
	         for(int j=0;j<s.length()-1;j++){
	             for(int k=j+1;k<s.length();k++){
	                 if(s.charAt(k)>s.charAt(j))
	                     y++;
	             }
	         }
	      //   System.out.println(y);
	         int min=y;
	         for(int j=0;j<s.length();j++){
	             for(char k='a';k<='z';k++){
	                 if(s.charAt(j)!=k){
	                     StringBuilder s1=new StringBuilder(s);
	                    // char c1=s1.charAt(k);
	                     //s1.charAt(j)='1';
	                     s1.setCharAt(j,k);
	                     y=ycalc(s1);
	                     if(Math.abs((int)s.charAt(j)-(int)k)+y<min)
	                         min=Math.abs((int)s.charAt(j)-(int)k)+y;
	                 }
	             }
	         }
	      
	         System.out.println(min);
	     }
	    }
	    
}
class Reader {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	/** call this method to initialize reader for InputStream */
	static void init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	/** get next word */
	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {

			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}