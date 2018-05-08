import java.util.Scanner;

public class lab8_2 {
	  public static void main(String[] args) {
	        long n = 0;
	        long m = 0;
	        long x = 0;
	        long y = 0;
	        long ans = 0;

	        Scanner s = new Scanner(System.in);
	        for (int i = 0; i < 1; i++) {
	            m = s.nextLong();
	            n = s.nextLong();
	            x = s.nextLong();
	            y = s.nextLong();
	        }
	        // int ans = solution(m, n, x, y);
	        long p = m;
	        long work = 0;
	        if (n == 1) {
	            p = 1;
	            ans = (m - 1) * x;
	            System.out.println(ans);
	        } else {
	        	long k= (y * n) ;
	        	if(k % (x * (n - 1))==0) {
	        		k=k/(x * (n - 1));
	        	}else {
	        		k=(k/(x * (n - 1)))+1;
	        	}
	        	k=Math.max(k,2);
	            while (p > 1) {
	                if (p  < n) {
	                    work += x * (p - 1);
	                    break;
	                } else if (p % n == 0) {
	                    if (p < k) {
	                        work += (p - 1) * x;
	                        p = 1;
	                    } else {
	                        work += y;
	                        p = p - (p - (p / n));
	                    }
	                } else {
	                    long tar= (p/n)*n;
	                    work+=(p-tar)*x;
	                    p=tar;
	                }
	            }
	            ans = work;
		        System.out.println(ans);
	        }
	        

	    }
}
