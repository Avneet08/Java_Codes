package lesson1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rec=new Rectangle();
		Trngl tri=new Trngl();
		rec.set_values(10, 10);
		tri.set_values(10, 10);
		System.out.println(rec.Area());
		System.out.println(tri.Area());
	}

}
