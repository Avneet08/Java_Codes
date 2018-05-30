import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class er2 {

	 public static void main(String[] args) {
		 try {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        ArrayList<Integer> a = new ArrayList<Integer>();
	        for(int a_i=0; a_i < n; a_i++){
	           // a[a_i] = in.nextInt();
	            a.add(in.nextInt());
	        }
	        Collections.sort(a);
	        int min = 10000000;
	        for (int i = 1; i < n; i++) {
	            min = Math.min(Math.abs(a.get(i)-a.get(i-1)), min);
	        }
	        System.out.println(min);
	    }
		 catch(Exception c) {
			System.out.println(c); 
		 }
	 }
	 
}
