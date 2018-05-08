
public class D_Memoization_Fib {
	static int fib(int n,int[] lookup)
	  {
	    if (lookup[n] == -1)
	    {
	      if (n <= 1)
	          lookup[n] = n;
	      else
	          lookup[n] = fib(n-1,lookup) + fib(n-2,lookup);
	    }
	    return lookup[n];
	  }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int[] lookup=new int[n+1];
		for(int i=0;i<=n;i++) {
			lookup[i]=-1;
		}
		System.out.println(fib(n,lookup));;
	}

}
