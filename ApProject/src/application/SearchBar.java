package application;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class SearchBar{
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
     
      s.executeQuery ("SELECT Name,Code ,Post FROM firstschema78.courses2");
      ResultSet rs = s.getResultSet ();
      int count = 0;
      ArrayList<String> db=new ArrayList<String>();
      while (rs.next ())
      {
    	  String nameVal = rs.getString ("Name");
          String idVal = rs.getString ("Code");
          String catVal = rs.getString ("Post");
          String[] words=catVal.split("\\s");
        for(int i=0;i<words.length;i++){
        	if(words[i].toLowerCase().equals(p.toLowerCase())){
        		db.add(nameVal);
        		break;
        	}
        }
          /*System.out.println (
                  "id = " + idVal + ", name = " + nameVal
                  + ", category = " + catVal);*/
         
        //  ++count;
      }
Iterator itr = db.iterator();
      
      while(itr.hasNext()) {
         Object element = itr.next();
         System.out.println(element + " ");
         
      }
      rs.close ();
      s.close ();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
}
}
