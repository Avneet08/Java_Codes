import java.util.Scanner;

public class Lab8 {

	public static void main(String[] args) throws StackOverflowError {
		// TODO Auto-generated method stub
		 try {
	            Scanner sc = new Scanner(System.in);
	            Long m =sc.nextLong();
	            Long n=sc.nextLong();
	            Long x=sc.nextLong();
	            Long y=sc.nextLong();
	            Long threshold=(m-1)*x;
	            Long energy=findminEner(m,n,x,y,threshold);
	            System.out.println(energy);
		 }
		 catch (Exception e) {
	            return;
	        }
	}

	private static Long findminEner(Long m, Long n, Long x, Long y, Long threshold) throws StackOverflowError{
		long sum=0;
		//System.out.println(n);
		if(n==1) {
			threshold=(m-1)*Math.min(x, y);
			return threshold;
		}
		
		if(m-1<n) {
			//System.out.println(threshold);
			threshold=(m-1)*x;
			return threshold;
		}
		else {
        for(Long i=m;i>1;i--) {
        	
        	if(i %n==0) {
        		long p=((i)-(i-(i/n)));
    			sum+=y+findminEner(p,n,x,y,threshold);
        		if(Math.abs(sum)<threshold) {
        			threshold=sum;
        		}
        	}
        	else {sum+=x;}
        	
        }
        
		return threshold;
		}
		
	}

}
