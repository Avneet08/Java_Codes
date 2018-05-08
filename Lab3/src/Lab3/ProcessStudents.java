package Lab3;

public class ProcessStudents {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] students=new Student[10];
		students[0]=new Student("2016123","Mehak Saha","B.Tech-CSE", 6.7);
		students[1]=new Student("2016021","Krishna Kumar","B.Tech-CSM", 8.7);
		students[2]=new Student("2016103","Balaram","B.Tech-CSE", 6.7);
		students[3]=new Student("2016211","Pooja Jain","B.Tech-ECE", 8.9);
		students[4]=new Student("2016120","Tanya Gupta","B.Tech-CSE", 4.5);
		students[5]=new Student("2016003","Prerna Saha","B.Tech-ECE", 8.7);
		students[6]=new Student("2016113","Valari Sinha","B.Tech-CSM", 8.3);
		students[7]=new Student("2016013","Mona Roy","B.Tech-CSE", 6.7);
		students[8]=new Student("2016112","Pulkit Saha","B.Tech-ECE", 9.7);
		students[9]=new Student("2016223","Pheona James","B.Tech-CSE", 9.3);
		ProcessStudents ps=new ProcessStudents();
		Student[] sortedlist=ps.SortStudents(students);
		ps.display(sortedlist);
	}
	private Student[] SortStudents(Student[] students) {
		// TODO Auto-generated method stub
	
		for(int i=0;i<students.length -1;i++){
			int smallest=i;
			for(int j=i+1;j<students.length ;j++){
				
				if(students[smallest].cgpa<students[j].cgpa){
					 smallest=j;
				 }
				else if(students[smallest].cgpa==students[j].cgpa){
					if(Integer.parseInt( students[smallest].r_no )<Integer.parseInt(students[j].r_no)){
						 
						smallest=j;
					}
				}
				
			}
			Student min= students[i];
			students[i]=students[smallest];
			students[smallest]=min;
		}
		return students;
	}

	private void display(Student[] sortedlist) {
		// TODO Auto-generated method stub
		for(int k=0;k< sortedlist.length;k++){
			System.out.print(sortedlist[k].r_no+" "+sortedlist[k].name+" "+sortedlist[k].Programm+" "+sortedlist[k].cgpa+"\n");
		
		
		}
	}


}
