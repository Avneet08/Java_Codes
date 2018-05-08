import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




//Avneet Kaur
//2016233
// Taking the input in a string converting it into chararray and recursively comparing the pair the pair is a char array
// that is used to create pairs 

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
public class lab1_ada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		// TODO Auto-generated method stub
				Reader.init(System.in);
				try {
					int T=Reader.nextInt();
					int i=0;
					
					String[] input=new String[T];
					while(i<T){
						 input[i]=Reader.next();
						 compareChar(input[i]);
						i++;
					}
					
					}catch (IOException e) {
						e.printStackTrace();
					}
	}

	private static void compareChar(String string) {
		char[] stringcopy=string.toCharArray();
		int i=0;
		char[] ts=new char[100];
		while(i<string.length()){
		 int j=comparepair(stringcopy,i,ts);
		 i=j;}
	
		System.out.println(ts);
	}
	private static void cc(char[] stringcopy){
		int i=0;
		
		if(stringcopy[0]=='a' ){
			int j;
			for(j=1;j<=stringcopy.length;j++){
				if(stringcopy[j]=='a' || (stringcopy[j]=='b' && stringcopy[j+1]=='b')   ){
					continue;
				}
				else if(stringcopy[j]=='\u0000'){
					break;
				}
				else{
					break;
				}
				
			}
			j=1;
			for(int u=0;u<stringcopy.length;u++){
				j=u+1;
				if((stringcopy[u]=='b' && stringcopy[j]=='b')  ){
					if(stringcopy[j+1]=='a'){
						continue;
					}
					else if(stringcopy[j+1]=='\u0000'){
						System.out.println("Valid");
						break;
					}
				}
			}
			System.out.println("Invalid");
			
			
		}
	}
	private static int comparepair(char[] stringcopy,int i,char[] ts) {
		char[] pair=new char[2];
		
		 int j=0;
		 int u=i;
		int result=0;
		while(j<2){
		pair[j]=stringcopy[i];
		//System.out.println(pair[j]);
		u++;j++;
		
	}
		
		//System.out.println(stringcopy[i]stringcopy[i+1]);
		if((stringcopy[i]>stringcopy[i+1]) && (stringcopy[i]-stringcopy[i+1])>3 && i==stringcopy.length){
			ts[i]='b';
			ts[i+1]='a';
			i+=1;
		}
		else if(stringcopy[i]<stringcopy[i+1] &&  (stringcopy[i+1]-stringcopy[i])>3){
			ts[i]='a';
			ts[i+1]='b';
			i+=1;
		}
		else if((stringcopy[i]-stringcopy[i+1])<=3|| (stringcopy[i+1]-stringcopy[i])<=3 ){
			if(i==0){
				ts[i]='a';
				ts[i+1]='a';
				i+=1;
			}
			else if(stringcopy[i-1]=='a'){
				ts[i]='a';
				ts[i+1]='a';
				i+=1;
				
			}
			 
			else if(stringcopy[i-1]=='b'){
			ts[i]='b';
				ts[i+1]='b';
				i+=1;
			}
			else{
				ts[i]='a';
				ts[i+1]='a';
				i+=1;
			}
		}	
		
		return i;
	}

}
