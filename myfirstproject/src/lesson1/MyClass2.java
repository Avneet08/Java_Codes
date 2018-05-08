package lesson1;

public class MyClass2 {

	public static void main(String[] args) {
		int sub1 =30;
		int sub2=60;
		if (sub1>=35 && sub2>=35){
			System.out.println("the condition is true");
			
			
		}else{
			System.out.println("the cond is false");
		}
		// whenever we wnt to use multiple condn statement it is lengthy so we can use switch statement
		int score=100;
		switch(score)
		{
		
		
		case 90:
			System.out.println("very gud");
			break;
		case 60:
			System.out.println("gud");
			break;
		case 40:
			System.out.println("0k");
			break;
		case 30:
			System.out.println("work hard");
			break;
		default:
			System.out.println("the grades are not defined");
			

		
		}
		
	}

}
