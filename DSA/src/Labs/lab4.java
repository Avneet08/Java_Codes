package Labs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node1 {
	private int data;
	private Node link;
	
	public void Node (int givendata, Node givenlink) {
		//THIS IS THE CONSTRUCTOR TO INITIALISE THE NODE
		this.data = givendata;
		this.link = givenlink;
	}
	
	public void setData(int givendata) {
		//THE DATA PARAMETER IS SET INDIVIDUALLY
		this.data = givendata;
	}
	
	public void setLink(Node givenlink) {
		//THE LINK PARAMETER IS SET INDIVIDUALLY
		this.link = givenlink;
	}
	public Node getLink() {
        return link;
    }
	public int getData() {
		// TODO Auto-generated method stub
		return data;
	}
}
public class lab4 {
	/*static Node Front;
public static void insert(int v,int pos){
	Node ptr=Front;
	Node cur=Front.getLink();
	Node nptr=new Node(v,null);
	int count=0;
	
	while(ptr.getLink()!=null){
		ptr=ptr.getLink();
		count++;
	}
	if(count==pos){
		ptr.setLink(nptr);
	nptr.setLink(ptr.getLink());
		
	}
	
}
void Display(){
	Node ptr=Front;
	while(ptr.getLink() != null){
		System.out.print(ptr.getData()+ " ");
		ptr = ptr.getLink();
	}
	System.out.print(ptr.getData());
}*/
	public static void main(String[] args)throws java.lang.Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(
				new InputStreamReader( System.in ) );
		//br.split(" ");
		System.out.println("enter");
		StringBuilder sb=new StringBuilder();
		try{
			int T= Integer.parseInt( br.readLine() );
			sb.append(T);
			for (int i=0;i<sb.length();i++){
				System.out.println(sb);
			}
			
			
	}
		catch(Exception e){}
	}
}
