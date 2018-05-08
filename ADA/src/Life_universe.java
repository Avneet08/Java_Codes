import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Life_universe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	            Scanner sc = new Scanner(System.in);
	            long d=5/*Long.MAX_VALUE*/;
	            Queue<Integer> q = new LinkedList<>();
	            while(d>=0) {
	            	int d2=sc.nextInt();
	            	q.add(d2);
	            	d--;
	            }
	            int c=q.remove();
	            while(c!=42) {
	            	System.out.println(c);
	            }
		 }
		 catch(Exception e) {
			 return;
		 }
	}

}
