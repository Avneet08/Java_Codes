package pra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class uniqueness {
boolean checkUnique(String s){
	boolean isUnique=true;
	char[] arr=s.toCharArray();
	
	for(int i=0;i<arr.length;i++){
		int ch=arr[i];
		if(s.indexOf(ch)!=s.lastIndexOf(ch)){
			isUnique=false;
			break;
		}
		
	}
	return isUnique;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
			uniqueness b=new uniqueness();
			String s=sc.nextLine();
			System.out.println(b.checkUnique(s));


	}

}
