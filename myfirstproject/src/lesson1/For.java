package lesson1;

public class For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={100,31,26,48,52};
		/*for (init;exp,increment)*/
		/*for(int index=0;index<5;index++)
		{
			System.out.println(array[index]);
		}*/
		for(int element/*name of variable*/: array)
		{
			System.out.println(element);
		}
	}

}
