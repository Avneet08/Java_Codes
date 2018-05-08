package Labs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.StringTokenizer;



public class arrayquery {
	public int posmin=0;
    public int posmax=0;
   
    int[] insertatpos(int[] arr,int pos,int num){
    
	for(int i=arr.length-1;i>pos;i--){
		arr[i]=arr[i-1];
	}
      arr[pos]=num; 
      
	
        return arr;  
	
    	
    }
    int[] Deleteatpos(int[] arr,int pos){
    	int i;
    	if(pos!=0){
        for (i=pos; i<arr.length-1; i++)
            arr[i] = arr[i+1];
        
    	}
    	else{
    		arr[pos]=0;
    			
    		}
    	return arr;
    }
    int Shiftindices(int[] arr,int pos ){
    	int count=0;
    	for(int i=0;i<arr.length;i++){
    		if(arr[i]!=0){
    			count++;
    			
    		}
    	}
        int Shift=count-pos;
        if(Shift>=0){
        return Shift;
    }
        else{
        	return 0;
        }
        
    }
    void Display(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
            System.out.print(arr[i]+ " ");}
        }
        System.out.println('\n');
    }
    int []  DeleteMin(int[] arr){
        int min=arr[0];
       if(count(arr)==1){
           posmin=0;
           arr=Deleteatpos(arr,0);
       }
       else{
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min && arr[i]!=0){
                min=arr[i];
                posmin=i;
            }
           }
       //System.out.println(posmin);
        arr=Deleteatpos(arr,posmin);
       } 
        return arr;
    }
    int [] DeleteMax(int[] arr){
      int max=arr[0];
      if(count(arr)==1){
          posmax=0;
           arr=Deleteatpos(arr,0);
      }
      else{
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
                posmax=i;
            }
        }
        
        arr=Deleteatpos(arr,posmax);
      }
        return arr;  
    }
    int count(int[] arr){
    	int count=0;
    	for(int i=0;i<arr.length;i++){
    	if(arr[i]!=0){
    		count++;
    	}
    	}
        return count;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
			Reader8.init(System.in);
		try {
			int MaxN = Reader8.nextInt();
			int n = Reader8.nextInt();
			int query = Reader8.nextInt();
			int arr[] = new int[MaxN];
			arrayquery b=new arrayquery();
			for (int i=0; i<n; i++) {
				arr[i]=Reader8.nextInt();
				 
			}
			for (int i=1; i<query+1; i++) {
				 
				 int userin = Reader8.nextInt();
				if (userin == 2 ){
						b.DeleteMin(arr);
						System.out.println(b.count(arr)+ " "+b.Shiftindices(arr,b.posmin));
				}
					else if (userin==3){
						b.DeleteMax(arr);
					System.out.println(b.count(arr)+ " "+b.Shiftindices(arr,b.posmax));
					} 
					else if(userin==4){
					    b.Display(arr);
					}
					else if(userin==1){
						int pos=Reader8.nextInt();
					    int num=Reader8.nextInt();
					    int ni=b.Shiftindices(arr,pos);
					    b.insertatpos(arr,pos,num);
					    System.out.println(b.count(arr)+ " "+ni);
					}
			}
			
			
		
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		 /*int arr[] ={11,24,5,9,32,7,0,0};
		    int num=43;
		    int pos=4;
		arrayquery b=new arrayquery();
		
		int n=b.Shiftindices(arr, pos);
		b.insertatpos(arr, num, pos);
		
		b.Display(arr);
		System.out.println(n);
		
		
		//b.Display(b.Deleteatpos(arr, 4));
		b.Display(b.DeleteMax(arr));
		System.out.println(b.Shiftindices(arr, b.posmax));
		b.Display(b.DeleteMin(arr));
		System.out.println(b.Shiftindices(arr, b.posmin));
		//b.Display(b.Deleteatpos(arr, 2));
		
		
		//b.Shiftindices(arr, 4);*/
		
		
	}
}
class Reader8 {
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

