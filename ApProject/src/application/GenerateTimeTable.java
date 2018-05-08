package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class GenerateTimeTable {
	public static void main(String[] args)
	  {
		Scanner sc=new Scanner(System.in); 
		String p=sc.nextLine();
		
	try
	{
    String myDriver = "org.gjt.mm.mysql.Driver";
    String myUrl = "jdbc:mysql://localhost:3306/firstschema";
    Class.forName(myDriver);
    Connection conn = DriverManager.getConnection(myUrl, "root", "#Avneet9654");
    
    Statement s = conn.createStatement();
   
    s.executeQuery ("SELECT Name,Course1,Course2,Course3,Course4,Course5,Course6,Course7 FROM firstschema.studentcourses");
    ResultSet rs = s.getResultSet ();
   // int count = 0;
    ArrayList<String> db=new ArrayList<String>();
    HashMap<String,String> hm_mon=new HashMap<String,String>();
    HashMap<String,String> hm_tue=new HashMap<String,String>();
    HashMap<String,String> hm_wed=new HashMap<String,String>();
    HashMap<String,String> hm_thur=new HashMap<String,String>();
    HashMap<String,String> hm_fri=new HashMap<String,String>();
    
    while (rs.next ())
    {
    	String nameVal = rs.getString ("Name");
    	if(nameVal.toLowerCase().equals(p.toLowerCase())){
    		String c1 = rs.getString ("Course1");
            String c2 = rs.getString ("Course2");
            String c3 = rs.getString ("Course3");
            String c4 = rs.getString ("Course4");
            String c5 = rs.getString ("Course5");
            String c6 = rs.getString ("Course6");
            String c7 = rs.getString ("Course7");
            db.add(c1); db.add(c2); db.add(c3);
            db.add(c4);db.add(c5);db.add(c6);db.add(c7);
    	}
    
    }
/*Iterator itr = db.iterator();
    
    while(itr.hasNext()) {
       Object element = itr.next();
       System.out.println(element + " ");
       
    }*/
    rs.close ();
    s.close ();
    Statement s2 = conn.createStatement();
    
    s2.executeQuery ("SELECT Code,MonCT,MonCR,TueCT,TueCR,WedCT,WedCR,ThurCT,ThurCR,FriCT,FriCR FROM firstschema.coursestt");
    
    ResultSet rs2 = s2.getResultSet ();
    
    while (rs2.next ())
    {
    	String code = rs2.getString ("Code");
    	//System.out.println(code);
    		if(db.contains(code)){
    			String c1 = rs2.getString ("MonCT");
                String c2 = rs2.getString ("MonCR");
                String c3 = rs2.getString ("TueCT");
                String c4 = rs2.getString ("TueCR");
                String c5 = rs2.getString ("WedCT");
                String c6 = rs2.getString ("WedCR");
                String c7 = rs2.getString ("ThurCT");
                String c8 = rs2.getString ("ThurCR");
                String c9 = rs2.getString ("FriCT");
                String c10 = rs2.getString ("FriCR");
                
                String entry=c2+","+code;
                if(c1.equals("-1")){
                	continue;
                }else{
                	hm_mon.put(c1, entry);
                }
                if(c3.equals("-1")){
                	continue;
                }else{
                	hm_tue.put(c3, entry);
                }
                if(c5.equals("-1")){
                	continue;
                }else{
                	hm_wed.put(c5, entry);
                }
                if(c7.equals("-1")){
                	continue;
                }else{
                	hm_thur.put(c7, entry);
                }
                if(c9.equals("-1")){
                	continue;
                }else{
                	hm_fri.put(c9, entry);
                }
                
    		}
    	
    	
    	
    }
    
    rs2.close ();
    s2.close ();
    
Statement s3 = conn.createStatement();
    
    s3.executeQuery ("SELECT Code,TutDay,TutTime,TutVenue,LabDay,LabTime,LabVenue FROM firstschema.coursestt");
    
    ResultSet rs3 = s3.getResultSet ();
    
    while (rs3.next ()){
    	String code = rs3.getString ("Code");
    	System.out.println(code);
    		if(db.contains(code)){
    			String tutd = rs3.getString ("TutDay");
    			if(tutd.equals("Wednesday")){
    				String c1 = rs3.getString ("TutTime");
                    String c2 = rs3.getString ("TutVenue");
                    String c3=c2+","+code+"(Tut)";
                    hm_wed.put(c1, c3);
    			}else if(tutd.equals("Monday")){
    				String c1 = rs3.getString ("TutTime");
                    String c2 = rs3.getString ("TutVenue");
                    String c3=c2+","+code+"(Tut)";
                    hm_mon.put(c1, c3);
    			}
    			String labd = rs3.getString ("LabDay");
    			if(labd.equals("Thursday")){
    				String c1 = rs3.getString ("LabTime");
                    String c2 = rs3.getString ("LabVenue");
                    String c3=c2+","+code+"(Lab)";
                    hm_thur.put(c1, c3);
    			}
    			if(labd.equals("Friday")){
    				String c1 = rs3.getString ("LabTime");
                    String c2 = rs3.getString ("LabVenue");
                    String c3=c2+","+code+"(Lab)";
                    hm_fri.put(c1, c3);
    			}
    		}
    }
   
    /*for(Map.Entry m:hm_mon.entrySet()){  
  	   System.out.println(m.getKey()+" "+m.getValue());  
  	  } System.out.println('\n');
    	*/
 rs3.close ();
 s3.close ();
 Statement st6 = conn.createStatement();
 String sql6 = "DELETE FROM generatett";
 int delete = st6.executeUpdate(sql6);
 
 Statement st = conn.createStatement(); 
 String sql_mon = "insert into generatett(Day,9_10,10_11,11_12,12_1,1_2,2_3,3_4,4_5) values(?,?,?,?,?,?,?,?,?)";
 PreparedStatement ps = conn.prepareStatement(sql_mon);
 int count=0;
 String mon="Monday";
 ps.setString(1,mon);
  int j=2;
  for(int i=9;i<17;i++){
	if(i>12){count=i-12;}else{count=i;}
	if(j<10){
	if(hm_mon.containsKey(Integer.toString(count)) ){
		 ps.setString(j,hm_mon.get(Integer.toString(count)));}else{
		 ps.setString(j,"-1");}}j++;}ps.executeUpdate();
		// System.out.println("hi1");
		 
		 Statement st2 = conn.createStatement(); 
		 String sql_tue = "insert into generatett(Day,9_10,10_11,11_12,12_1,1_2,2_3,3_4,4_5) values(?,?,?,?,?,?,?,?,?)";
		 PreparedStatement ps2 = conn.prepareStatement(sql_tue);
		 int count2=0;
		 String Tue="Tuesday";
		 ps2.setString(1,Tue);
		  int j2=2;
		  for(int i=9;i<17;i++){
			if(i>12){count2=i-12;}else{count2=i;}
			if(j2<10){
			if(hm_tue.containsKey(Integer.toString(count2)) ){
				 ps2.setString(j2,hm_tue.get(Integer.toString(count2)));}else{
				 ps2.setString(j2,"-1");}}j2++;}ps2.executeUpdate(); //System.out.println("hi12");
Statement st3 = conn.createStatement(); 
String sql_wed = "insert into generatett(Day,9_10,10_11,11_12,12_1,1_2,2_3,3_4,4_5) values(?,?,?,?,?,?,?,?,?)";
PreparedStatement ps3 = conn.prepareStatement(sql_wed);
int count3=0;
String wed="Wednesday";
ps3.setString(1,wed);
 int j3=2;
 for(int i=9;i<17;i++){
	if(i>12){count3=i-12;}else{count3=i;}
	if(j3<10){
	if(hm_mon.containsKey(Integer.toString(count3)) ){
		 ps3.setString(j3,hm_wed.get(Integer.toString(count3)));}else{
		 ps3.setString(j3,"-1");}}j3++;}ps3.executeUpdate();
		 //System.out.println("hi13");
Statement st4 = conn.createStatement(); 
String sql_thur = "insert into generatett(Day,9_10,10_11,11_12,12_1,1_2,2_3,3_4,4_5) values(?,?,?,?,?,?,?,?,?)";
PreparedStatement ps4 = conn.prepareStatement(sql_thur);

String thur="Thursday";
ps4.setString(1,thur);
 int count4=0;int j4=2;
 for(int i=9;i<17;i++){
	if(i>12){count4=i-12;}else{count4=i;}
	if(j4<10){
	if(hm_mon.containsKey(Integer.toString(count4)) ){
		 ps4.setString(j4,hm_thur.get(Integer.toString(count4)));}else{
		 ps4.setString(j4,"-1");}}j4++;}ps4.executeUpdate();
		 //System.out.println("hi14");
		 
		 Statement st5 = conn.createStatement(); 
		 String sql_fri= "insert into generatett(Day,9_10,10_11,11_12,12_1,1_2,2_3,3_4,4_5) values(?,?,?,?,?,?,?,?,?)";
		 PreparedStatement ps5 = conn.prepareStatement(sql_fri);
		 int count5=0;
		 String fri="Friday";
		 ps5.setString(1,fri);
		 int j5=2;
		  for(int i=9;i<17;i++){
		 	if(i>12){count5=i-12;}else{count5=i;}
		 	if(j5<10){
		 	if(hm_mon.containsKey(Integer.toString(count5)) ){
		 		 ps5.setString(j5,hm_fri.get(Integer.toString(count5)));}else{
		 		 ps5.setString(j5,"-1");}}j5++;}ps5.executeUpdate();
		 		// System.out.println("hi15");
  }
	
  catch (Exception e)
  {
    System.err.println("Got an exception! ");
    System.err.println(e.getMessage());
  }
}
}
