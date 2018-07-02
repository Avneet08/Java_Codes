package src2;

import java.util.HashMap;
import java.util.Scanner;

public class p2_j1 {
	public static int countS(int n) {
        
		  
        if (n == 0)
            return 0;
        else
            return 1 + countS(n & (n - 1));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int q=sc.nextInt();
		 HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();  
		//int arr[]=new int[n];
		//System.out.println(Arrays.toString(arr));
		 for(int i=0;i<n;i++) {
			 hm.put(i, 0);
		 }
		for(int i=0;i<q;i++) {
			int num=sc.nextInt();
			int x=sc.nextInt();
			if(num==1) {
				//System.out.println("hi");
				int a=2*hm.get(x)+1;
				hm.put(x, a);
				
				
			}
			else if(num==2) {
				//System.out.println("hi1");
				//arr[x]=arr[x]/2;
				int a=hm.get(x)/2;
				hm.put(x, a);
				
			}
			else if(num==3) {
				
				int y=sc.nextInt();
				
				long  count=0;
				if(y==n) {
					y=n-1;
				}
				
				for(int j=x;j<=y;j++) {
				
					 count+=countS(hm.get(j));
					}
				System.out.println(count);
				}
				
				
				
				
			}
		}
		catch(Exception e) {
			System.out.println("\n");
			System.out.println(e);
		}
		
	}
}
