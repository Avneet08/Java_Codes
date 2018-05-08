
//Avneet Kaur
//2016233


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
        	
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
class Student{
	private String name;
	private String rno;
	private String Branch;
	private int dist;
	
	Student(String name,String rno,String Branch,int dist){
		this.name=name;
		this.rno=rno;
		this.Branch=Branch;
		this.dist=dist;
		}
	Student(){
		this.name=null;
		this.rno=null;
		this.Branch=null;
		this.dist=0;
		}
	public String getBranch() {
		return this.Branch;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getrno() {
		return this.rno;
	}
	
	public int getdist() {
		return this.dist;
	}
	
}

public class HoselAllocationSys {
	private Student stu;
	public void rooms(ArrayList<Student> students,int rooms){
		
		sort(students);
		
		ArrayList<Student> finalli=new ArrayList<Student>();
		ArrayList<Student> ug=new ArrayList<Student>();
		ArrayList<Student> pg=new ArrayList<Student>();
		ArrayList<Student> phd=new ArrayList<Student>();
		
		for(int i=0;i<students.size();i++){
			//System.out.println(students.get(i).getBranch());
			String z="PhD";
			String x="UG";
			String y="PG";
			if(students.get(i).getBranch().matches(z)){
				phd.add(students.get(i));
			}
			else if(students.get(i).getBranch().matches(y)){
				pg.add(students.get(i));
				
			}
			else if(students.get(i).getBranch().matches(x)){
				ug.add(students.get(i));
			}
			
		}
		int pgs=pg.size();
		int ugs=ug.size();
		int phds=phd.size();
		//System.out.println(phds);
		//System.out.println(pgs);
		//System.out.println(ugs);
		
		double mi= Math.ceil(rooms/2);
		
		
		 if (phds>mi){
			for(int j=0;j<mi;j++){
				finalli.add(phd.get(j));
			}
		}
		 else {
				for(int j=0;j<phds;j++){
					finalli.add(phd.get(j));
				}
			}
		 
		 
			
			
			 if (pgs>mi){
				for(int j=0;j<mi;j++){
					finalli.add(pg.get(j));
				}
			}
			 else {
					for(int j=0;j<pgs;j++){
						finalli.add(pg.get(j));
					}
				}
			 
			
			 int remain=rooms-finalli.size();
			 int count=0;
			 while(remain!=0){
				 if(count<ugs){
				 finalli.add(ug.get(count));
				 count++;
				 remain--;
				 }
			 }
			
				
				
				//System.out.println(finalli.size());
		printList(finalli);		 
	}
	public void printList(ArrayList<Student> finalli){
		for(int i=0;i<finalli.size();i++){
			System.out.println(finalli.get(i).getName()+" "+finalli.get(i).getrno()+" "+finalli.get(i).getBranch()+" "+finalli.get(i).getdist());
		}
	}
	
	
	
	
	
	public ArrayList<Student> sort(ArrayList<Student> students){
		   for (int i = 0; i < students.size(); i++) {
	            
	            int pos = i;
	            for (int j = i; j < students.size(); j++) {
	                if (students.get(j).getdist() > students.get(pos).getdist())
	                    pos = j;
	            }
	           
	            Student min = students.get(pos);
	            students.set(pos, students.get(i));
	            students.set(i, min);
	            
	        }
		
			
			
		      
		return students;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try {
			int m =Reader.nextInt();
			int n=Reader.nextInt();
			ArrayList<Student> students=new ArrayList<Student>();
			for(int i=0;i<m;i++){
				
				String name=Reader.next();
				String Rno =Reader.next();
				String Branch=Reader.next();
				int dist=Reader.nextInt();
			Student stu=new Student(name,Rno,Branch,dist);
			students.add(stu);
			}
			
			/*

7 5
Madhur MT1454 PG 28
Shabad MT1754 PG 40
Rani 1454 PhD 28
Megha MT1554 PG 32
Jay 2015054 UG 33
Seema MT1704 PG 35
Ajay 2015031 UG 33

Avneet 89767 PhD 41
Avnyt 89767 PhD 43
Avn 897 PhD 40

			/*
			 * 
			 */
			
			//System.out.println(students.get(0).getName());
			HoselAllocationSys h=new HoselAllocationSys();
			h.rooms(students,n);
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

