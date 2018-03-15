package lesson1;

public class Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// also called functions in python
	/*piece of code which executes some logic.
		and we can wrap a method 
		with name and we can call 
		it again an again*/
		mymethod("Akshay");
		int Sum=Add(5,6,11);
		int result= Sum*10;
		System.out.println(result);
		
		
	}
	public static void mymethod(String name){
		System.out.println("Hello "+name);
		
	}
	/*public static void Add(int a,int b.int c){
		System.out.println(a+b+c);
		
	}*/
	
	//parsing parameters to method and returning values 
	public static int Add (int a,int b,int c){
		//System.out.println(a+b+c);
		return(a+b+c);
		
	}
	
}
