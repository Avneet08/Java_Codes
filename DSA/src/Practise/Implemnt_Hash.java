package Practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


class Reader3 {
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

class Hash_Tbl{
	int capacity;
	int[] arr;
	public  Hash_Tbl(int capacity){
		this.capacity=capacity;
		 arr=new int[this.capacity];
	}
	private static int nextPrime(int n){
		if(n%2==0){
			n++;
		}
		
		for(;!isPrime(n);n+=2);
			return n;
			
		
	}
	private static boolean isPrime(int n){
		if(n==2 || n==3){
			return true;
			
		}
		 if(n==1 || n%2==0){
			return false;
			
		}
		 for(int i=3;i*i<=n;i+=2)
			 if(n%i==0){
				 return false;
			 }
			 return true;
		 
	}
	
	public void insertHash(int num){
		if(arr[num % capacity]==0 ){
		arr[num % capacity]= num;
		}
		else{int i=1;
		if(arr[((num % capacity)+i*i )% capacity]==0 ){
			arr[((num % capacity)+i*i )% capacity]= num;
			
			}
		else{
		i++;
		}
		}
	}
	public boolean contains(int ele)
    {
        return arr[ele % capacity] == ele;
    }
 
	public void clear(){
		int []arr=new int[capacity];
		
	}
	public void PrintTbl(){
		for(int i=0;i<capacity;i++){
			System.out.print(arr[i]+" ");
			
		}
		System.out.println();
	}
	public void deleteHash(int num){
		if(arr[num % capacity]== num){
			arr[num % capacity]= 0;
			
		}
		else{
			System.out.println("Not Found");
		}
	}
}
public class Implemnt_Hash {

	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		
		Reader3.init(System.in);
		try {
			int MaxN = Reader3.nextInt();
			int n = Reader3.nextInt();
			
			Hash_Tbl b=new Hash_Tbl(MaxN);
			
			for (int i=0; i<n; i++) {
				 
				 int userin = Reader3.nextInt();
					if (userin == 2 ){
						int num = Reader3.nextInt();
						b.contains(num);
						System.out.println("");
					}
					else if(userin==1){
						int re=Reader3.nextInt();
						b.insertHash(re);
					}
					else if (userin==5){
						int query = Reader3.nextInt();
						 b.deleteHash(query);
					} 
					else if (userin==3){
						b.PrintTbl();
					}
					else if(userin==4){
						b.clear();
					}
					else{
						System.out.println("invalid");
					}
			}
			
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}*/
		Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");
        /** Make object of HashTable **/
        Hash_Tbl ht = new Hash_Tbl(scan.nextInt() );
 
        char ch;
        /**  Perform HashTable operations  **/
        do    
        {
            System.out.println("\nHash Table Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. contains");            
            System.out.println("4. clear");            
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                ht.insertHash( scan.nextInt() ); 
                break;                          
            case 2 :                 
                System.out.println("Enter integer element to delete");
                ht.deleteHash( scan.nextInt() ); 
                break;                        
            case 3 : 
                System.out.println("Enter integer element to check if present");
                System.out.println("Contains : "+ ht.contains(scan.nextInt() ));
                break;                                   
            case 4 : 
                ht.clear();
                System.out.println("Hash Table Cleared\n");
                break;
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /** Display hash table **/
            ht.PrintTbl();  
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
	}

}
