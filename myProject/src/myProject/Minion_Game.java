package myProject;
import java.util.Scanner;
public class Minion_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter some string");
		String  s=scan.nextLine();
		String vowel="AEIOU";
		int Kevin=0;
		int Stuart=0;
		int k=s.length();
		for(int i=0;i<s.length();i++){
			
				if(vowel.indexOf(s.charAt(i))!=-1){
		             Kevin+=k-i;
					}
				else{
				     Stuart+=k-i;
					
				}
			
			
		}
		if(Kevin>Stuart){
			System.out.println("kevin "+Kevin);
		}
		else if (Kevin<Stuart){
			System.out.println("Stuart "+Stuart);
		}
		else{
			System.out.println(" Draw");
		}
		
		
	}

}
