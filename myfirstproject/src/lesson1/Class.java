package lesson1;

public class Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Add(1,36));
		System.out.println(Add("helo","world"));
		System.out.println(Add(5.35,9.25));
	}
	public static int Add(int a ,int b){
		return (a+b);
	}
	public static double Add(double a ,double b){
		return (a+b);
	}
	public static String Add(String a ,String b){
		return (a+b);
	}
}
