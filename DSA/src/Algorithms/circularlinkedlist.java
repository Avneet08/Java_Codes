package Algorithms;

import java.util.*;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

class Node {
	private int data;
	private Node link;
	public int key;
	
	public Node (int givendata, Node givenlink) {
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
public class circularlinkedlist {
	Node head;
	public circularlinkedlist(int num){
		head = null;
		for(int j=1;j<=num;j++){
			Node nptr = new Node (j, null);	
			if(head==null){
				head = nptr;
				nptr.setLink(head);
				}
			else{
				Node temp = head;
				while(temp.getLink() != head){
					temp = temp.getLink();
				}
				temp.setLink(nptr);
				nptr.setLink(head);
			}
		}
	}
    void Display(){
		Node front=head;
		while(front.getLink() != head){
			System.out.print(front.getData()+ " ");
			front = front.getLink();
		}
		System.out.print(front.getData());
	}
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		try {
			int test = Reader.nextInt();
			while(test-- > 0){
				int num = Reader.nextInt();
				circularlinkedlist cl = new circularlinkedlist(num);
				
				//cl.Display();
				//Deletion
				Node temp = cl.head;
				while(temp.getLink() != temp){
					temp.setLink(temp.getLink().getLink());
					temp = temp.getLink();
				}
				System.out.println( temp.getData());

			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}




	
