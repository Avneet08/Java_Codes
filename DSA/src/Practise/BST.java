package Practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
public class BST {
	class Node {
        int key;
        Node left, right;
 
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
	Node root;
	BST(){
		root=null;
	}
	 void printPostorder(Node node)
	    {
	        if (node == null)
	            return;
	        printPostorder(node.left);
	        printPostorder(node.right);
	        System.out.print(node.key + " ");
	    }
	 void insert(int key) {
	       root = insertRec(root, key);
	    }
	    Node insertRec(Node root, int key) {
	        if (root == null) {
	            root = new Node(key);
	            return root;
	        }
	        if (key < root.key)
	            root.left = insertRec(root.left, key);
	        else if (key > root.key)
	            root.right = insertRec(root.right, key);
	        return root;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		
		try {
			int test=Reader.nextInt();
			for(int i=0;i<test;i++){
				BST b=new BST();
				int num_nodes=Reader.nextInt();
				for(int j=0;j<num_nodes;j++){
					int x=Reader.nextInt();
					b.insert(x);
				}
				b.printPostorder(b.root);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
