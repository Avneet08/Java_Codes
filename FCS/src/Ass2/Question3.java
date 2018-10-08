package Ass2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.Scanner;

public class Question3 {
	public static String sha256(String base) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	public static StringBuffer F(String b)  throws IOException{
		String c=b.replaceAll("[^0-9]+", "");
		System.out.println(c+" "+c.length());
		int no=c.length()%10;
		StringBuffer buffer=new StringBuffer();

		for(int i = no+5;i<no+9;i++) {
			buffer.append(c.charAt(i));
			}

		 String fileName = "hash.txt";

	        try {
	            FileWriter fileWriter =
	                new FileWriter(fileName);

	            BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);

	            bufferedWriter.write("Hello there,");
	          
	            bufferedWriter.close();
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error writing to file '"
	                + fileName + "'");
	           
	        }
return buffer;
		
	}
	public static void Verify(String Hash,String otp_u) {
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		   String line = null;
		String fileName = "hash.txt";
try {
	Scanner sc = new Scanner(System.in);
	LocalDateTime a =LocalDateTime.now();

	String b=sha256(a.toString());
	System.out.println(b);
	StringBuffer otp=F(b);
	System.out.println(otp);
	String otp_u=sc.next();
	 

     // This will reference one line at a time
  

    
         // FileReader reads text files in the default encoding.
         FileReader fileReader = 
             new FileReader(fileName);

         // Always wrap FileReader in BufferedReader.
         BufferedReader bufferedReader = 
             new BufferedReader(fileReader);
String hash=null;
         while((line = bufferedReader.readLine()) != null) {
              hash=line;
         }   
System.out.println("hash is "+hash);
         // Always close files.
         bufferedReader.close();    
         Verify(hash,otp_u);
     
     
	
}

catch (Exception e) {
	return;
}



	}

}
