package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ForgetPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); 
		String p=sc.nextLine();
		
		String pwd=sc.nextLine();
		
		try
		{
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/firstschema78";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "#Avneet9654");
	      
	      Statement s = conn.createStatement();
	     
	      s.executeQuery ("SELECT Username,Password FROM firstschema78.login_dataset");
	      ResultSet rs = s.getResultSet ();
	      int count = 0;
	      ArrayList<String> db=new ArrayList<String>();
	      while (rs.next ())
	    	  
	      {
	    	  String nameVal = rs.getString ("Username");
	          String idVal = rs.getString ("Password");
	          if(nameVal.equals(p) && idVal.equals(pwd)){
	        	  System.out.println("enter new pwd");
		          String new_pwd=sc.nextLine();
		          String query = "update login_dataset set Password = ? where Username = ?";
		          PreparedStatement preparedStmt = conn.prepareStatement(query);
		          preparedStmt.setString   (1, new_pwd);
		          preparedStmt.setString(2, nameVal);

		          // execute the java preparedstatement
		          preparedStmt.executeUpdate();
		          break;
	          }
	          
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
