import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class LandLeveling {
	private static void Landret(int[] arr,int k,int n,int[] minvalues) {
		 Deque<Integer> q = new LinkedList<Integer>();
	       int  i =0;
	       for(i=0;i<k;i++) {
	       
	        	 while(!q.isEmpty() && arr[i] <= arr[q.peekLast()]){
	                q.removeLast();
	            }
	            q.addLast(i);
	            
	        }
	        i = k;
	       for( i=k;i<n;i++) {
	       
	            minvalues[i-k] = arr[q.peek()];
	            while (!q.isEmpty() && q.peek() <= i-k){
	                q.removeFirst();
	            }
	            while (!q.isEmpty() && arr[i] <= arr[q.peekLast()]){
	                q.removeLast();
	            }
	            q.addLast(i);
	            
	        }
	        minvalues[n-k] = arr[q.peek()];
	}
private static long land_min(int n ,int k,int[] minvalues,ArrayList<Integer> arr ) {
	 long min_value = Long.MAX_VALUE;
     int i =0;
     for(i=0;i<=n-k;i++) {
         long sum = 0;
         int j = i;
 
         while(j < i+k) {
             sum = sum + arr.get(j)- minvalues[i];
             j++;
         }
         min_value = min(sum, min_value);
       
     }
    return min_value;
}
private static long min(long sum,long min_value) {
	if(sum<min_value) {
		return sum;
	}else {
	return min_value;
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 int n=sc.nextInt();
		 int k=sc.nextInt();
		 ArrayList<Integer> arr_copy=new ArrayList<Integer>();
		 int[] arr =new int[n];
		 for(int i=0;i<n;i++) {
			 
			 arr[i]=sc.nextInt();
			 arr_copy.add( arr[i]);
		 }
		 int minvalues[] = new int[n-k+1];
		 Landret(arr,k,n,minvalues);
	      
	    long x=land_min(n,k,minvalues,arr_copy);
	    System.out.println(x);
		 
	}

}
