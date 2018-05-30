import java.util.Scanner;

public class LongestUncommon {
	 public static int findlength(String a, String b) {
	        if (a.equals(b))
	            return -1;
	        return Math.max(a.length(), b.length());
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
		 String a=in.next();
		 String b=in.next();
		 int c=findlength(a,b);
		 if(c>=4) {
			 System.out.println(c);
		 }
		 else {
			 System.out.println("Best Friends Forever" );
		 }
		 
	}

}
