import java.io.IOException;
import java.util.ArrayList;

public class lab5 {

		static int Findway(int set[], int n,int count, int sum)
		{
			
		if (sum == 0) {
			return count;}
		if (n == 0 && sum >= 0)
			return 0;
		if (set[n-1] > sum) {
			return Findway(set, n-1,count, sum);}
		int A=Findway(set, n-1,count-1, sum) ;
		int B=Findway(set, n-1,count+1, sum-set[n-1]);
			
		return  B-A;
		}
		public static void main (String args[]) throws IOException
		{
			Reader.init(System.in);
			int T=Reader.nextInt();
			for(int i=0;i<T;i++) {
				int N=Reader.nextInt();
				int K=Reader.nextInt();
				int[] weight=new int[N];
				for(int j=0;j<N;j++) {
					weight[j]=Reader.nextInt();
				}
			
			if (Findway(weight, weight.length,0, K) >0) {
				if(Findway(weight, weight.length,0, K)%2==0){
					System.out.println("Ambiguous");
				}
				System.out.println(Findway(weight, weight.length,0, K));
			}
			else
				System.out.println("Not Possible");
		}
	}
}


