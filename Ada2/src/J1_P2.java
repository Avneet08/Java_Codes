import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class J1_P2 {
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
		int arr[]=new int[n];
		//System.out.println(Arrays.toString(arr));
		for(int i=0;i<q;i++) {
			int num=sc.nextInt();
			int x=sc.nextInt();
			if(num==1) {
				//System.out.println("hi");
				arr[x]=2*arr[x]+1;
				
			}
			else if(num==2) {
				//System.out.println("hi1");
				arr[x]=arr[x]/2;
				
			}
			else if(num==3) {
				
				int y=sc.nextInt();
				
				long  count=0;
				if(y==arr.length) {
					y=arr.length-1;
				}
				
				for(int j=x;j<=y;j++) {
				
					 count+=countS(arr[j]);
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

