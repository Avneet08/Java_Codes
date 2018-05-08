//Avneet Kaur
//2016233

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
class College{
	public double messScore;
	private double libScore;
	private double hosScore;
	private double acadScore;
	private double finalSc;
	

	private String name;
	private int fees;
	private char naac;
	private Mess mess;
	private Library lib;
	private Academics acad;
	private Hostel hostel;
	College(String name,Mess mess,Hostel hostel,Library lib,Academics acad,int fees,char naac){
		this.name=name;
		this.mess=mess;
		this.lib=lib;
		this.acad=acad;
		this.hostel=hostel;
		this.fees=fees;
		this.naac=naac;
	}
	public void setMessSc(int no){
		this.messScore=no/**0.25*/;
	}
	public void setfinalSc(double sum){
		this.finalSc=sum;
	}
	public double getfinalSc(){
		return this.finalSc;
	}
	public void setHostSc(int no){
		this.hosScore=no/**0.20*/;
	}
	public void setLibSc(int no){
		this.libScore=no/**0.25*/;
	}
	public void setAcadSc(int no){
		this.acadScore=no/**0.30*/;
	}
	
	public Mess getMess(){
		return this.mess;
	}
	public String getname(){
		return this.name;
	}
	public Hostel getHostel(){
		return this.hostel;
	}
	public Library getLibrary(){
		return this.lib;
	}
	public Academics getAcademics(){
		return this.acad;
	}
	public char getnaac(){
		return this.naac;
	}
	public int getfees(){
		return this.fees;
	}
	public double getMessSc(){
		return this.messScore;
	}
	public double getHosSc(){
		return this.libScore;
	}
	public double getLibSc(){
		return this.hosScore;
	}
	public double getAcadSc(){
		return this.acadScore;
	}
}
class Mess{
	private double food_availability;
	private double food_nutrition;
	private double hygiene_maintenance;
	private double food_delivery;
	Mess(double food_availability,double food_nutrition,double hygiene_maintenance,double food_delivery){
		this.food_availability =food_availability;
		this.food_nutrition =food_nutrition;
		this.hygiene_maintenance=hygiene_maintenance;
		this.food_delivery=food_delivery;
	}
	public double getfoodavailability() {
		return this.food_availability;
	}
	public double getfoodnutrition() {
		return this.food_nutrition;
	}
	public double gethygiene() {
		return this.hygiene_maintenance;
	}
	public double getfooddelivery() {
		return this.food_delivery;
	}
	
	
	
}
class Library{
	private double  books_availability;
	private double digital_facility ;
	private double efficiency;
	Library(double books_availability,double digital_facility,double efficiency ){
		this.books_availability=books_availability;
		this.digital_facility=digital_facility;
		this.efficiency=efficiency;
	}
	public double getbavailability() {
		return this.books_availability;
	}
	public double getdigitalfacility() {
		return this.digital_facility;
	}
	public double getefficiency() {
		return this.efficiency;
	}
	
}
class Hostel{
	private double room_conditions;	
	private double studying_facilities;
	private double  cleanliness;
	private double recreational_facilities; 
	
	Hostel(double room_conditions,double studying_facilities,double cleanliness,double recreational_facilities ){
		this.room_conditions=room_conditions;
		this.studying_facilities=studying_facilities;
		this.cleanliness=cleanliness;
		this.recreational_facilities=recreational_facilities;
		
	}
	public double getroomconditions() {
		return this.room_conditions;
	}
	public double getstudyingfacilities() {
		return this.studying_facilities;
	}
	public double getcleanliness() {
		return this.cleanliness;
	}
	public double getrecreationalfacilities() {
		return this.recreational_facilities;
	}
}
class Academics{
	private double knowledge;
	private double domains;
	private double course_structure;
	
	Academics(double knowledge,double domains,double course_structure){
		this.knowledge=knowledge;
		this.domains=domains;
		this.course_structure=course_structure;
		
	}
	public double getknowledge() {
		return this.knowledge;
	}
	public double getdomains() {
		return this.domains;
	}
	public double getcoursestructure() {
		return this.course_structure;
	}
}
class Compare{
	public College college;
	//private ArrayList<College> colg;
	
	public  void sortLibrary(ArrayList<College> colg){
		for (int i = 0; i < colg.size(); i++) {
            
            int pos = i;
            Library p = colg.get(i).getLibrary();
            for (int j = i; j < colg.size(); j++) {
            	College tmp = null;
            	Library q = colg.get(i).getLibrary();
                if ((p.getbavailability() +p.getdigitalfacility()+p.getefficiency())/3< (q.getbavailability()+q.getdigitalfacility()+q.getefficiency())/3){
                	tmp = colg.get(i);
	                  colg.set(i,colg.get(j));
	                  colg.set(j,tmp);
                    }
                
	                }
		               
			                
	                }
     
		for(int i=0;i<colg.size();i++){
			colg.get(i).setLibSc(i);
			System.out.print(colg.get(i).getname()+" ");
			
		}
		System.out.println('\n');
                   
	}
	
	
	public  void sortAcademics(ArrayList<College> colg){
		for (int i = 0; i < colg.size(); i++) {
            
            int pos = i;
            Academics p = colg.get(i).getAcademics();
            for (int j = i; j < colg.size(); j++) {
            	College tmp = null;
            	Academics q = colg.get(i).getAcademics();
                if (p.getknowledge() +p.getdomains()+2*p.getcoursestructure()< q.getknowledge()+q.getdomains()+2*q.getcoursestructure()){
                	tmp = colg.get(i);
	                  colg.set(i,colg.get(j));
	                  colg.set(j,tmp);
                    
                    }
                
           
            }
            
		}
		for(int i=0;i<colg.size();i++){
			colg.get(i).setAcadSc(i);
			//System.out.println(colg.get(i).getAcadSc());
			System.out.print(colg.get(i).getname()+" ");
		}
		System.out.println('\n');          
	}
	
	public void sortHostel(ArrayList<College> colg){
		for (int i = 0; i < colg.size(); i++) {
            
            int pos = i;
            Hostel p = colg.get(i).getHostel();
            for (int j = i; j < colg.size(); j++) {
            	College tmp = null;
            	Hostel q = colg.get(i).getHostel();
                if (p.getroomconditions() < q.getroomconditions()){
                	tmp = colg.get(i);
	                  colg.set(i,colg.get(j));
	                  colg.set(j,tmp);
                    break;}
                    //System.out.println(j);
                    
                else if(p.getroomconditions() == q.getroomconditions()){
                	if (p.getstudyingfacilities() < q.getstudyingfacilities()){
                		tmp = colg.get(i);
		                  colg.set(i,colg.get(j));
		                  colg.set(j,tmp);
	                    break;
                	}
                	
	                else if(p.getstudyingfacilities() == q.getstudyingfacilities()){
	                	
	                	if (p.getcleanliness() < q.getcleanliness()){
	                		tmp = colg.get(i);
			                  colg.set(i,colg.get(j));
			                  colg.set(j,tmp);
		                    break;
	                	}
		                    
		                else if(p.getcleanliness() == q.getcleanliness()){
		                	
		                	if (p.getrecreationalfacilities() < q.getrecreationalfacilities()){
		                		tmp = colg.get(i);
				                  colg.set(i,colg.get(j));
				                  colg.set(j,tmp);
			                    }
		                }
	                	}
                	}     
			                
		                
			                
	                
            
                }
           
           
        
            
            }
            

		for(int i=0;i<colg.size();i++){
			colg.get(i).setHostSc(i);
			System.out.print(colg.get(i).getname()+ " ");
			//System.out.println(colg.get(i).getname());
		}
	   
		System.out.println('\n');             
	}
	
	public void sortMess(ArrayList<College> colg){
		for (int i = 0; i < colg.size(); i++) {
            
            int pos = i;
            Mess p = colg.get(i).getMess();
            for (int j = i; j < colg.size(); j++) {
            	College tmp = null;
            	Mess q = colg.get(j).getMess();
                if (p.getfoodavailability() < q.getfoodavailability()){
                	tmp = colg.get(i);
	                  colg.set(i,colg.get(j));
	                  colg.set(j,tmp);
                    break;}
                    //System.out.println(j);
                    
                else if(p.getfoodavailability() == q.getfoodavailability()){
                	if (p.getfoodnutrition() < q.getfoodnutrition()){
                		tmp = colg.get(i);
		                  colg.set(i,colg.get(j));
		                  colg.set(j,tmp);
	                    break;
                	}
                	
	                else if(p.getfoodnutrition() == q.getfoodnutrition()){
	                	
	                	if (p.gethygiene() < q.gethygiene()){
	                		tmp = colg.get(i);
			                  colg.set(i,colg.get(j));
			                  colg.set(j,tmp);
		                    break;
	                	}
		                    
		                else if(p.gethygiene() == q.gethygiene()){
		                	
		                	if (p.getfooddelivery() < q.getfooddelivery()){
		                		tmp = colg.get(i);
				                  colg.set(i,colg.get(j));
				                  colg.set(j,tmp);
			                    }
		                }
	                	}
                	}     
			                
		                
			                
	                
            
                }
           
           
        
            
            }
            

		for(int i=0;i<colg.size();i++){
			colg.get(i).setHostSc(i);
			System.out.print(colg.get(i).getname()+ " ");
			//System.out.println(colg.get(i).getname());
		}
	   
		System.out.println('\n');             
	}
	
	/*
    public  void sortMess(ArrayList<College> colg){
			for (int i = 0; i < colg.size(); i++) {
		 for (int j = i ; j < colg.size(); j++) {
		        	  
		        	  College tmp = null;
		        	  
		              if (colg.get(i).getMess().getfoodavailability() < colg.get(j).getMess().getfoodavailability()) {
		            	  
		                  tmp = colg.get(i);
		                  colg.set(i,colg.get(j));
		                  colg.set(j,tmp);
		                  //System.out.println(colleges.get(tmp));
		                  break;
		              }
		              
		              else if (colg.get(i).getMess().getfoodavailability() == colg.get(j).getMess().getfoodavailability()) {
		            	
		            	  if (colg.get(i).getMess().getfoodnutrition() < colg.get(j).getMess().getfoodnutrition()) {
			            	  
			                  tmp = colg.get(i);
			                  colg.set(i,colg.get(j));
			                  colg.set(j,tmp);
			                  //System.out.println(colleges.set(j,tmp));
			                  break;
			              }
		            	  
		            	  else if (colg.get(i).getMess().getfoodnutrition() == colg.get(j).getMess().getfoodnutrition()) {
		            		  
		            		  if (colg.get(i).getMess().getfooddelivery() < colg.get(j).getMess().getfooddelivery()) {
				            	  
				                  tmp = colg.get(i);
				                  colg.set(i,colg.get(j));
				                  colg.set(j,tmp);
				                  //System.out.println(colleges.set(j,tmp));

				              }
		            		  
		            	  }
		                
		              }

		          }

		      }
			
		            
		
				for(int i=0;i<colg.size();i++){
					colg.get(i).setMessSc(i);
					System.out.print(colg.get(i).getname()+" ");
				}             
			System.out.println('\n');
		}*/
		
	void FinalSc(ArrayList<College> colg){
		
		for(int i=0;i<colg.size();i++){
			
			double sum=colg.get(i).getAcadSc()*0.30+colg.get(i).getHosSc()*.20+colg.get(i).getLibSc()*0.25+colg.get(i).getMessSc()*0.25;
			colg.get(i).setfinalSc(sum);
		}
		sortFinalScore(colg);
	}
	ArrayList<College> sortFinalScore(ArrayList<College> colg){
		for (int i = 0; i < colg.size(); i++) {
			for (int j = i+1; j < colg.size(); j++) {
            	 College tmp=null;
            	 
            	 College n=colg.get(i);
            	 College m=colg.get(j);
            	 if(n.getAcadSc()==n.getHosSc()){
            		 if(n.getMessSc()==n.getLibSc()){
            			 if(n.getMessSc()==n.getHosSc()){
            			 if(m.getAcadSc()==m.getHosSc()){
            				 if(m.getMessSc()==m.getLibSc()){
            					 if(m.getMessSc()==m.getHosSc()){
            						 if(n.getfees()<m.getfees()){
                						 System.out.println(n.getfees()+" "+m.getfees());
               	                	  tmp = n;
               	   	                  colg.set(i,m);
               	   	                  colg.set(j,tmp);
               	   	                  
               	                		}
                               	else if(n.getfees()==m.getfees()){
                               		System.out.println(n.getfees()+" "+m.getfees());
               		                	char s=n.getnaac();
               		                	char t=m.getnaac();
               		                		if(s<t){
               		                			tmp =n;
               		         	                  colg.set(i,m);
               		         	                  colg.set(j,tmp);
               		                		}
               		                	} 
            					 }
            				 }
            			 }
            		 }
            		 }
            	 }
            	 else if (colg.get(i).getfinalSc()<colg.get(j).getfinalSc()){
                   	//System.out.println(colg.get(i).getfinalSc()+ "	"+colg.get(j).getfinalSc());
   	                  tmp = colg.get(i);
   	                  colg.set(i,colg.get(j));
   	                  colg.set(j,tmp);
   	                  break;
   	                  }
            	  
     }
     }
		for(int i=colg.size()-1;i>=0;i--){
			System.out.println(colg.get(i).getname());
		}
		return colg;	
	}
		
	/*ArrayList<College> sortFinalSc(ArrayList<College> colg){
		for (int i = 0; i < colg.size(); i++) {
            
			
            for (int j = i+1; j < colg.size(); j++) {
            	 College tmp=null;
            	
               if (colg.get(i).getfinalSc()<colg.get(j).getfinalSc()){
                	System.out.println(colg.get(i).getfinalSc()+ "	"+colg.get(j).getfinalSc());
	                  tmp = colg.get(i);
	                  colg.set(i,colg.get(j));
	                  colg.set(j,tmp);
	                  }
                
                	
                }
            }
		
		
           
        
	for(int i=colg.size()-1;i>=0;i--){
		System.out.println(colg.get(i).getname());
	}
	return colg;	
	}*/
}
public class College_Compare {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try {
			
			int no=Reader.nextInt();
			ArrayList<College> college=new ArrayList<College>();
			for(int i=0;i<no;i++){
				String name=Reader.next();
				
				String mess=Reader.next();
				
				double a=Reader.nextDouble();
				double b=Reader.nextDouble();
				double c=Reader.nextDouble();
				double d=Reader.nextDouble();
				
				
				String hostel=Reader.next();
				
				double e=Reader.nextDouble();
				double f=Reader.nextDouble();
				double g=Reader.nextDouble();
				double h=Reader.nextDouble();
				
				
				String library=Reader.next();
				
				double n=Reader.nextDouble();
				double o=Reader.nextDouble();
				double p=Reader.nextDouble();
				

				
				String academics=Reader.next();
				
				double l=Reader.nextDouble();
				double j=Reader.nextDouble();
				double k=Reader.nextDouble();
				
			
				String fee=Reader.next();
				int fees=Reader.nextInt();
				String naacCer=Reader.next();
				String naac8=Reader.next();
				String naac=Reader.next();
				
				Mess m=new Mess(a,b,c,d);
				Hostel hos=new Hostel(e,f,g,h);
				Library lib=new Library(n,o,p);
				Academics aca=new Academics(l,j,k);
				
				College colg=new College(name,m,hos,lib,aca,fees,naac.charAt(0));
				
				college.add(colg);
				
			}
			ArrayList<College> mess=new ArrayList<College>();
			mess.addAll(college);
			ArrayList<College> Hostel=new ArrayList<College>();
			Hostel.addAll(college);
			ArrayList<College> Academics=new ArrayList<College>();
			Academics.addAll(college);
			ArrayList<College> Library=new ArrayList<College>();
			Library.addAll(college);
			
			Compare n=new Compare();
			//n.methodscall(college);
			n.sortMess(mess);
			n.sortHostel(Hostel);
			n.sortAcademics(Academics);
			n.sortLibrary(Library);
			n.FinalSc(college);
		
            
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}

/*
 * 3
DTU
Mess 3.0 2.5 1.9 3.6
Hostel 4.0 9.8 5.6 7.8
Library 8.0 6.0 3.9
Academics 6.7 5.4 3.9
Fees 10000
NAAC Certificate A
IIITD
Mess 1.0 2.5 1.9 3.6
Hostel 8.9 3.4 7.8 3.2
Library 10.0 11.0 9.9
Academics 9.7 4.4 8
Fees 20000
NAAC Certificate A
NSIT
Mess 4.0 2.5 1.9 3.6
Hostel 10.8 3.4 7.8 3.2
Library 10.9 11.0 9.9
Academics 12.8 4.4 8
Fees 2000
NAAC Certificate A



3
DTU
Mess 3.0 2.5 1.9 3.6
Hostel 4.0 9.8 5.6 7.8
Library 8.0 6.0 3.9
Academics 6.7 5.4 3.9
Fees 20000
NAAC Certificate C
IIITD
Mess 3.0 2.5 1.9 3.6
Hostel 4.0 9.8 5.6 7.8
Library 8.0 6.0 3.9
Academics 6.7 5.4 3.9
Fees 20000
NAAC Certificate A
NSIT
Mess 3.0 2.5 1.9 3.6
Hostel 4.0 9.8 5.6 7.8
Library 8.0 6.0 3.9
Academics 6.7 5.4 3.9
Fees 20000
NAAC Certificate B



 

 */
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