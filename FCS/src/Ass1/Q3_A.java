package Ass1;

import java.util.Scanner;

public class Q3_A {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="Slnpzshabylzohssthrluvshdylzwljapunhulzahispzotluavmylspnpvuvywyvopipapunaolmylllelyjpzlaolylvmvyhiypknpunaolmyllkvtvmzwlljovyvmaolwylzzvyaolypnoavmaolwlvwslwlhjlhisfavhzzltislhukavwlapapvuaolnvclyutluamvyhylkylzzvmnyplchujlz nhtl vm aoyvulz zlhzvu lpnoazwvpslyz qvu zuvd huk khlulyfz ahynhyflu av rpss lhjo vaoly" ;
		//String str2=new String();
		//StringBuffer str2= new StringBuffer();
	
		System.out.println("this countdown will continue from 1-25");
		System.out.println();
			for(int o=1;o<26;o++) {
			System.out.println(de_casercipher(str,o));
			System.out.println();
			//System.out.println("\n");
			System.out.println("Does it makes any sense??");
			//System.out.println();
			System.out.println("Enter y/n");
			Scanner sc = new Scanner(System.in);
			String ans =sc.next();
			if(ans.equals("y")) {
				break;
			}
			}
		
		
		
		}
		
	private static String de_casercipher(String str, int shift)
	{
		String str2= new String();
		int i=0;
		
			while(i<str.length()) {
			if(str.charAt(i)==' ') {
				
				str2+=" ";
			}
			else if (Character.isUpperCase(str.charAt(i)))
			{
				char ch = (char)(((int)str.charAt(i) +
						(26-shift) - 65) % 26 + 65);
				
				str2+=ch;
			}
			else
			{
				char ch = (char)(((int)str.charAt(i) +
						(26-shift) - 97) % 26 + 97);
				
				str2+=ch;
			}
			i++;
		}
		return str2;
	}

	
	}


