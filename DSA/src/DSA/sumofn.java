package DSA;

public class sumofn {
//recursion
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		sum=Sum(5);
		
		System.out.println(sum);
	}
	 static int Sum(int n){
		if(n==0){
			return 0;
	}
		else{
			return n+Sum(n-1);
		}

	}
}
