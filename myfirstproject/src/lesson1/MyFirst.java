package lesson1;

public class MyFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student mark=new Student();//mark here is the object or we can call it instance
		mark.setId(2016266);
		mark.setName("Mark");
		mark.setAge(18);
		
		
		Student tom=new Student();//mark here is the object or we can call it instance
		tom.setId(2016221);
		tom.setName("Tom");
		tom.setAge(19);
		System.out.println(mark.getName()+" is "+mark.getAge()+" years old");
		System.out.println(tom.getName()+" is "+tom.getAge()+" years old");
	}

}
