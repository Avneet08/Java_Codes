package lesson1;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// same as a variable but it can store more than 1 value but the onlu restriction is that u hv to store same kind of data type
		int[] myintarray={1,2,3,4,5};//prefered way
		int myintarray2[]={1,2,3,4,5};
		/* 
		 * int[] array=new int[3];
		 * int[] array={1,2,3};
		 * int[] array=new int[]{1,2,3};
		 */
		int index=0;
		
		while(index<6){
			System.out.println(myintarray[index]);	
			index++;
		}
		
	}

}
