
	package Labs;
import java.util.*;


import java.io.*;
class Node{
	int data;
	//Node Root;
	Node left;
	Node right;
	int key;

	Node(){
		this.data=0;
		left=null;
		right=null;
	}
	Node(int data){
		this.data=data;
		left=null;
		right=null;
		key=data;
	}
	
}


public class Lab8 {
	public static int max=0;
	public  Node root;
	public Lab8(){
		this.root = null;
	}
	public void Display1(Node root){
		if(root!=null){
			System.out.print(" "+root.data);
			Display(root.left);
			Display(root.right);
			
		}
	}
	
	public void insert(int key){
		Node new2 = new Node(key);

		if(root==null){
			root = new2;
			return;
		}
		Node cur = root;
		Node parent = null;
		while(true){
			parent = cur;
			if(key<cur.data){				
				cur = cur.left;
				if(cur==null){
					parent.left = new2;
					return;
				}
			}else{
				cur = cur.right;
				if(cur==null){
					parent.right = new2;
					return;
				}
			}
		}
	}
	/*public Node DeleteNode (Node root, int N) {
		if (root == null) {
			return null;
		}
		else if (N < root.data) {
			root.left = DeleteNode(root.left, N);
		}
		else if (N > root.data) {
			root.right = DeleteNode(root.right, N);
		}
		else {
			if (root.left != null && root.right != null) {
				Node temp = root;
				Node minRight = Smallest(temp.right);
				root.data = minRight.data;
				root.right = DeleteNode(root.right, minRight.data);
			}
			else if (root.left != null) {
				root = root.left;
			}
			else if (root.right != null) {
				root = root.right;
			}
			else {
				root = null;
			}
		}
		return root;
	}*/
	
	public Node deleteRoot(Node root, int key) {
		if (root.right != null && root.left != null ) {
			Node nptr = root;
			Node min = Smallest(nptr.right);
			root.data = min.data;
			root.right = delete(root.right, min.data);
		}
		else if (root.right != null) {
			root = root.right;
		}
		else if (root.left != null) {
			root = root.left;
		}
		else {
			root = null;
		}
		return root;
	}
	
	public Node delete(Node root,int key){
		Node parentnode = root;
		Node current = root;
		boolean LeftChild = false;
		if (root.data == key){
			return deleteRoot(root, root.data);
		}
		while(current.data!=key){
			parentnode = current;
			if(current.data>key){
			LeftChild = true;
				current = current.left;
			}else{
				LeftChild = false;
				current = current.right;
			}
			//base case
			if(current ==null){
				return null;
			}
		}
		
		if(current.right==null && current.left==null){
			if(current==root){
				root = null;
			}
			if(LeftChild ==true){
				parentnode.left = null;
			}else{
				parentnode.right = null;
			}
		}
		
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(LeftChild){
				parentnode.left = current.right;
			}else{
				parentnode.right = current.right;
			}
		}
		else if(current.left!=null && current.right!=null){
			
			
			Node successor	 = Smallest(current.right);
			current.data=successor.data;
			current.right=delete (current.right, successor.data);
			
		}	
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(LeftChild){
				parentnode.left = current.left;
			}else{
				parentnode.right = current.left;
			}
		}
			
		return root;		
	}
	Node Smallest(Node root)
	{    
		if(root.left==null){
			return root;
		}
		else{
            return Smallest (root.left);

		}
	    
	}
	
	 void rightview(Node node,int current){
		
		if(node==null)return;
		if(max<current){
			System.out.print(node.data+" ");
			max=current;
		}
		rightview(node.right,current+1);
		rightview(node.left,current+1);
		
		
	}
	 void Display(Node root){
		if(root!=null){
			System.out.print(" "+root.data);
			if(root.right!=null){
				Display(root.right);	
			}
			else{
				Display(root.left);
			}
			
			//System.out.print(" "+root.data);
			//Display(root.right);
			
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try {
			int MAXN = Reader.nextInt();
			int n = Reader.nextInt();
			
			Lab8 b=new Lab8();
			for (int i=0; i<MAXN; i++) {
				b.insert(Reader.nextInt());
				 
			}
			for (int i=0; i<n; i++) {
				 
				 int userin = Reader.nextInt();
					if (userin == 2 ){
						b.rightview(b.root,max+1);
						System.out.println("");
					}
					else if (userin==1){
						int query = Reader.nextInt();
						b.root = b.delete(b.root,query);
					} 
			}
			
			
			/*System.out.println("Original Tree : ");
			b.Display(b.root);
			System.out.println("");
			
			b.delete(4);
			b.Display(root);*/
		}
		catch (IOException e) {
			e.printStackTrace();
		}
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
