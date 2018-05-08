package Practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class linkdlst
{
	Node head; // head of list

	/* Linked list Node*/
	class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	
	void rhtrotate()
	{
	
		 Node prev=head;
		 Node cur=head.next;
		 Node p=cur;
		 while(cur.next!=null){
			 prev=cur;
			 cur=cur.next;
		 }
		 prev.next=null;
		 cur.next=head;
		 head=cur;
		
		
	}
	void max1(){
		
	}
	void count(int K)
	{
		Node ptr = head;
int arr[]=new int[6];
int w=1;
int count=1;
	while(ptr.next!=null && w <K){
		int ter=0;
		if(ptr.data==1){
			ter++;
			
		}
		ptr=ptr.next;
		
		
		if(count==K){
			w++;
			count++;
			
		}
		arr[ter]=ter;
	}
	
	
	for(int i=0;i<6;i++){
	    System.out.println(arr[i]);
	}	
	}

	void push(int new_data)
	{
		Node nw=new Node(new_data);
		if(head==null){
		head=nw;	
			
		}
		else{
			nw.next=head;
			head=nw;
		}
		
	}
	

	void printList()
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		
		/*Reader.init(System.in);
		try {
			int MAXN = Reader.nextInt();
			int K = Reader.nextInt();
			int P = Reader.nextInt();
			
			linkdlst b = new linkdlst();
			for (int i=1; i<MAXN; i++) {
				b.push(Reader.nextInt());
				 
			}
			for (int i=1; i<P; i++) {
				 
				 String userin = Reader.next();
					if (userin == "!" ){
						b.rhtrotate();
					}
					else if (userin=="?"){
						b.max1();
					} 
			}
			
			
		
		}
		catch (IOException e) {
			e.printStackTrace();
		}*/
		linkdlst llist = new linkdlst();
		llist.push(1);
		llist.push(0);
		llist.push(0);
		llist.push(1);
		llist.push(1);

		System.out.println("Given list");
		llist.printList();

		llist.rhtrotate();

		System.out.println("Rotated Linked List");
		llist.printList();
		llist.rhtrotate();

		llist.count(3);
	}
}
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
