package application;
import java.sql.*;
public class JavaMysqlSelectExample {
	 public static void main(String[] args)
	  {
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/firstschema";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "#Avneet9654");
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	     // String query = "SELECT * FROM firstschema.employeeinfo";

	      // create the java statement
	      Statement s = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	     // ResultSet rs = st.executeQuery(query);
	      s.executeQuery ("SELECT id, first_name,last_name  FROM firstschema.employeeinfo");
	      ResultSet rs = s.getResultSet ();
	      int count = 0;
	      while (rs.next ())
	      {
	          int idVal = rs.getInt ("id");
	          String nameVal = rs.getString ("first_name");
	          String catVal = rs.getString ("last_name");
	          System.out.println (
	                  "id = " + idVal + ", name = " + nameVal
	                  + ", category = " + catVal);
	         
	          ++count;
	      }
	      rs.close ();
	      s.close ();
	      System.out.println (count + " rows were retrieved");
	      
	      // iterate through the java resultset
	     
	     /* while (rs.next()){
	        int id = rs.getInt("id");
	        String firstName = rs.getString("first_name");
	        String lastName = rs.getString("last_name");
	        String dateCreated = rs.getString("date_created");
	        String isAdmin = rs.getString("is_admin");
	        int numPoints = rs.getInt("num_points");
	        
	        // print the results
	        System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
	      
	    	  
	      
	      }*/
	      s.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	  }
}
