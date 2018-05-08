package DSA;
import java.util.Scanner;

public class Threelegged_defenders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Threelegged_defenders arr1=new Threelegged_defenders();
		Threelegged_defenders.solve();
	}
	private static void solve(){
		Scanner input=new Scanner(System.in);
		int T=input.nextInt();
		for(int i=0;i<T;i++){
			int sum=0;
			int N=input.nextInt();
			for(int j=0;j<N;j++){
				int arr=input.nextInt();
				sum+=arr/3;
			}
			System.out.println(sum);
		}
				
				
	}
 }
			
		
		
	


