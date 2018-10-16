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
	public static StringBuffer F(String b) {
		String c=b.replaceAll("[^0-9]+", "");
		//System.out.println(c+" "+c.length());
		int no=c.length()%10;
		StringBuffer buffer=new StringBuffer();
		
		for(int i = no+5;i<no+9;i++) {
			buffer.append(c.charAt(i));
			}
return buffer;
		
	}
	public static void Verify(String Hash,String otp_u)  {
		StringBuffer otp=F(Hash);
		//System.out.println(otp+" ghvvg");
		if(otp.toString().equals(otp_u)) {
			System.out.println("Succesfull");
		}
		else
		{
			System.out.println("not succesfull");
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		   String line = null;
		String fileName = "hash.txt";
try {
	Scanner sc = new Scanner(System.in);
	LocalDateTime a =LocalDateTime.now();

	//String b=sha256(a.toString());
	//System.out.println("hash value is "+b);
	try (FileWriter outFile = new FileWriter("hash.txt");
			BufferedWriter bWriter = new BufferedWriter(outFile)) {
		bWriter.write(sha256(a.toString()));
	} catch (IOException e) {
		e.printStackTrace();
	}
	FileReader freader = new FileReader("hash.txt");
	BufferedReader br = new BufferedReader(freader);
	String s;
	s = br.readLine();
	freader.close();

	StringBuffer otp=F(s);
	System.out.println("hash value is "+s);
	System.out.println("otp for user is "+otp);
	System.out.println("Kindly enter the otp");
	String otp_u=sc.next();
	

         Verify(s,otp_u);
     
     
	
}

catch (Exception e) {
	return;
}



	}

}
