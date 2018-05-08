package DSA;

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
		for(int j=0;j<students.length-1;j++){
			int min=j;
			for(int i=j+1;i<students.length;i++){
				if(students[min].cgpa<students[i].cgpa){
					min=i;
					
				}
				else if(students[min].cgpa==students[i].cgpa){
					if(Integer.parseInt(students[i].rno)>(Integer.parseInt(students[min].rno))){
						min=i;
					}
				}
				
			}
			Student smallest=students[j];
			students[j]=students[min];
			students[min]=smallest;
			
		}
		return students;
			
		
	}

	private void display(Student[] sortedlist) {
		for(int k=0;k<sortedlist.length;k++){
			System.out.println(sortedlist[k].rno+" "+sortedlist[k].name+" "+sortedlist[k].Pro+" "+sortedlist[k].cgpa+"\n");
		
		}
		
	}

}


