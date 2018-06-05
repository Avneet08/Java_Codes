import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NAIVE_CHEF {


	public static void main(String[] args)throws IOException{

			Scanner sc = new Scanner(System.in);
		
		long t = sc.nextLong();
		for(int j=0;j<t;j++){
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int[] values = new int[N];
			for(int i=0; i<values.length; i++){
				values[i] = sc.nextInt();
			}
			int c1 = 0;
			int c2 = 0;
			int i=0;
				while(i<values.length) {
				if(values[i] == A){
					c1++;
				}if(values[i] == B){
					c2++;
				}
				i++;
			}
			
			double y = N*N;
			double z = (c1*c2)/y;
			System.out.printf("%10f", z);
			System.out.println(" ");
		}
	}
	

}
