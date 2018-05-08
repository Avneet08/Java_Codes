import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Avneet Kaur
//2016233
public class lab4 {
	private int man;
	private static int[][] friends;
	public lab4(int M) 
    {
        man = M;
        friends = new int[man + 1][man + 1];
    }
	public static void main(String[] args) throws IOException {
		
				Reader.init(System.in);
				int N=Reader.nextInt();
				int M=Reader.nextInt();
				int count=1;
				lab4 graph=new lab4(N);
				int g=(N*(N-1))/2;
				/*if(M>Math.min(15000, N)){
					System.out.println("NO");
					System.exit(0);
				}*/
				while(count<=M){
					int to = Reader.nextInt();
		            int  from = Reader.nextInt();
		            count++;
		            graph.makeEdge(to, from, 1);
	                
				}
				/*System.out.println("The adjacency matrix for the given graph is: ");
	            System.out.print("  ");
	            for (int i = 1; i <= N; i++)
	                System.out.print(i + " ");
	            System.out.println();
	 
	            for (int i = 1; i <= N; i++) 
	            {
	                System.out.print(i + " ");
	                for (int j = 1; j <= N; j++) 
	                    System.out.print(graph.getEdge(i, j) + " ");
	                System.out.println();
	            }*/
	            
	            int i=graph.checkTransitiive(friends, N);
	            if(i>=1){
	            	System.out.println("YES");
	            }
	            else{
	            	System.out.println("NO");
	            }
				
	}
	private int checkTransitiive(int [][] friends,int N){
		/*int i=1;int j=1;int k=1;
		while(i<=N){
			while(j<=N){
				if(getEdge(i,j)==1 ){
					while(k<=N){
						if(getEdge(j,k)==1 && getEdge(i,k)==1){
							System.out.println("Yes");
							return 1;
							
						}
						else{
							k++;
							
						}
					}
					
				}
				else{
					j++;
				}
			}i++;
		}return 0;*/
		int count=0;
		for (int k = 1; k <= N; k++)
        {for (int i = 1; i <= N; i++){
                for (int j = 1; j <= N; j++)
                {
                	if(friends[i][j]!=0 && friends[j][k]!=0 && friends[i][k]!=0){
                    	count++;
                    }else{
                    	continue;
                    }
                }
            }
            
        }
		
		return count;
	}
	private void makeEdge(int to, int from, int i)  {
		try{
		friends[to][from]=i;}
		catch(Exception e){
			System.out.println(e);  
		}
	}
	 /*public int getEdge(int to, int from) 
	    {
	        try 
	        {
	            return friends[to][from];
	        }
	        catch (ArrayIndexOutOfBoundsException index) 
	        {
	            System.out.println("The vertices does not exists");
	        }
	        return -1;
	    }*/

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