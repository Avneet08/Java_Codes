package src2;

import java.math.BigInteger;
import java.util.Scanner;

public class procon_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			int t =sc.nextInt();
			for(int i=0;i<t;i++) {
				int n=sc.nextInt();
				boolean flag=false;
				long x=sc.nextLong();
				for(int j=0;j<n;j++) {
					long ai=sc.nextLong();
					if(ai>=x) {
						flag=true;
					}
				}
				if(flag) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
				
			}
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
