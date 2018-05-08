package lesson1;

public class CubeClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cube cube1=new Cube();
		Cube cube2= new Cube(20,20,20);
		System.out.println(cube2.getCubeVol());
		
		System.out.println(cube1.getCubeVol());
	}

}
