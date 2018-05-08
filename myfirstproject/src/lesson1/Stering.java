package lesson1;

public class Stering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mystr="Hello World";
		int len=mystr.length();
		String str_lower=mystr.toLowerCase();
		String str_upper=mystr.toUpperCase();
		System.out.println(str_lower);
		System.out.println(str_upper);
		//to join two strs use + oper to concatinate two str as in python
		String s="hello "+"world"+"!";
	    System.out.println(s);
	    //replace function
	    String a="hello world!";
	    System.out.println(a.replace('l', 'n'));
	    System.out.println(a.indexOf('o'));
	    System.out.println(a.lastIndexOf('l'));
	    
		
		

	}

}
