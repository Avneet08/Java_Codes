package myProject;

import java.util.ArrayList;
import java.util.Stack;

public class CircleTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Object> d=new Stack<Object>();
		Integer c = 0 ;
		d.push("Sti");
		d.push(6);
		d.push(36);
		d.push("Asd");
		d.push("dbd");
		d.push(36);
		int sum=0;
		//System.out.println(d.peek());
			try{
			sum+=d.peek();	
			}
			catch(NumberFormatException	e){
				System.out.println("NonCoordinateException: Not a coordinate Exception"+ e);
			}
		
	}
}


