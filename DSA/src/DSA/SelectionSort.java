package DSA;

import java.util.*;
import java.util.stream.IntStream;
import java.io.*;


public class SelectionSort {

	public static void main(String[] args) {
		

		// TODO Auto-generated method stub
		//MyArray arr=new MyArray();
		//arr.Selection_Sort();
		float[] al={1,2,3,5,6};
		float[] c=arra(al);
		for(int i=0;i<al.length;i++){
			System.out.println(c[i]);
		}
		//System.out.println(c.toString());
	}
	public static float[]  arra(float[] al){
		return al;
	}
	public void Selection_Sort(){
		int[] my_array={5,2,4,6,1,3};
		for(int i=0;i<my_array.length-1;i++){
			
			for(int j=i+1;j<my_array.length;j++){
				int tmp=0;
				if(my_array[i]<my_array[j]){
					tmp=my_array[j];
					my_array[j]=my_array[i];
					my_array[i]=tmp;
					}
				}
			
			
		}
		System.out.print("sorted arr-"+Arrays.toString(my_array));
		
		/*for(int k=0;k<my_array.length;k++){
			System.out.print( my_array[k]+" ");
		}*/
		System.out.print("\n");
}

}
