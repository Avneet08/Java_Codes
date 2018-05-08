package Practise;

import java.util.*;

public class Exceptions_Practise {

	public static void main(String[] args) {
		String s = "hi";
		int length=0;
		try {
			 length += (s.length()>0)? Integer.parseInt(s):0;
		}

		catch (NullPointerException e) {
			System.out.println("String	was	null");
		}
		catch(NumberFormatException e){
			System.out.println("Not an Integer");
			
		}
		finally{
			System.out.println(length);
		}
	}
}
