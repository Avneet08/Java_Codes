package pra;

public class Student {
	String name;
	int age;
	int Rno;
	String branch;
	static int latestRno=0;
	
	
    public Student(){
    	name="Student";
    	Rno=0;
    	age=0;
    	branch=null;
    	
 }
    public Student(String name,int age,String branch  ){
    	this.name=name;
    	this.age=age;
    	
    	this.branch=branch;
    	latestRno++;
    	this.Rno+=latestRno;
    	
    }
    public String toString(){
    	return " "+name +" " + Rno + " " + age + " " + branch+" "+this.getlatestRno();
    }
    
    public int getRno() {
		return Rno;
	}
	public void setRno(int Rno) {
		this.Rno = Rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public void setlatestRno(int latestRno){
		this.latestRno=latestRno+1;
	}
	public int getlatestRno(){
		return latestRno;
	}

	public static void main(String[] args) {
		Student s1=new Student("Ram",19,"CSE");
		System.out.println(s1.toString());
		Student s2=new Student("Mohan",19,"CSE");
		System.out.println(s2.toString());
		Student s3=new Student("Rajiv",18,"CSAM");
		System.out.println(s3.toString());
		Student s4=new Student("Raman",21,"CSAM");
		System.out.println(s4.toString());
		Student s5=new Student("Neetu",20,"ECE");
		System.out.println(s5.toString());
		Student s6=new Student("Abc",18,"CSE");
		System.out.println(s6.toString());
		Student s7=new Student("Def",19,"ECE");
		System.out.println(s7.toString());
		Student s8=new Student("Cji",21,"CSAM");
		System.out.println(s8.toString());
		Student s9=new Student("Jhi",18,"CSAM");
		System.out.println(s9.toString());
		Student s10=new Student("Khyati",20,"ECE");
		System.out.println(s10.toString());
		
	}

}
