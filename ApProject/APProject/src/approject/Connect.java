/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

/**
 *
 * @author Bunny
 */
import java.sql.*;

import javax.swing.*;
public class Connect {
     static Connection con=null;
   
        public static Connection ConnectDB(){
             try{
           
          Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/approject","root","root");
          return con;
            
             }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            //return con;
    } catch (ClassNotFoundException e) {
                 // TODO Auto-generated catch block

			}
			return con;      
}
}
