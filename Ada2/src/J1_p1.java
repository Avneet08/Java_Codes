import java.util.Scanner;

public class J1_p1 {
	public static int find( int x,  int t )
	{

		int arr[] = {7, 3};
		
		if (t == 0)
			return 1;
		if (t < 0)
			return 0;
		if ( x <=0 && t >= 1)
			return 0;
		return find(  x - 1, t ) +
			find(   x, t-arr[ x-1] );
	}
	
	
	public static void main(String[] args) {
	
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
		
			
			if( find(2,  t)==0) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}
			
			
	}
	}

}
