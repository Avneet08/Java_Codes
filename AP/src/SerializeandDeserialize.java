import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/*class play implements java.io.Serializable{
	String name;
	play(String name){
		this.name=name;
	}
}*/
 class Employee implements java.io.Serializable {
	   public String name;
	   public String address;
	   public transient int SSN;
	   public int number;
	   
	   public void mailCheck() {
	      System.out.println("Mailing a check to " + name + " " + address);
	   }
	}
public class SerializeandDeserialize {
static ArrayList<String > dbd=new ArrayList<String>();

/*public static void serialize() throws IOException{
	
	play p1=new play("bfu");
	play p3=new play("bfuh");
	
	
	  dbd.add(p1);
	  dbd.add(p3);
	  FileOutputStream fout=new FileOutputStream("C:\\Users\\avnee\\Documents\\out1.txt");  
	  ObjectOutputStream out=new ObjectOutputStream(fout);  
	  for(play p:dbd){
			out.writeObject(p);}
		
			//out.writeObject(playlists);
			
	  //out.writeObject(p1);  
	  //out.close();  
	  System.out.println("success");  
	 } -/*/

/*public static void serialize() throws IOException{
	play e = new play("dbbj");
     
     FileOutputStream fileOut =
    	        new FileOutputStream("C:\\Users\\avnee\\Documents\\out1.txt");
    	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
     try {
        
        out.writeObject(e);
        
       
        //System.out.printf("Serialized data is saved in /tmp/employee.ser");
     }finally{
    	 out.close();
    	 fileOut.close();
     }
}*/
public static void deserialize() throws	IOException,ClassNotFoundException,EOFException{
	ObjectInputStream	in	=	null;	
	try	{	
		in =new ObjectInputStream(new FileInputStream("C:\\Users\\avnee\\Documents\\out1.txt"));	
		for(;;){
		

		}
		
	}
	finally	{	
			in.close();	
			}	
	
}
	public static void main(String[] args) throws IOException, ClassNotFoundException,EOFException {
		// TODO Auto-generated method stub
		dbd.add("dhi");
		dbd.add("dhi");
		dbd.add("dhi");
		System.out.println(dbd.size());
		dbd.clear();
		System.out.println(dbd.size());
		
		
	}

}
