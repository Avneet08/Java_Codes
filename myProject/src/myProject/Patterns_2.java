package myProject;

import java.util.Scanner;

public class Patterns_2 {

	public static void main(String[] args) {
		
        
		for(int i=5;i>=0;i--){
			for(int j=1;j<i;j++ ){
				System.out.print(" ");
				
			}
			for (int x=5;x>=i;x--){
				System.out.print("*");
				
			}
	    System.out.println("");
		}
				

			
	}
}