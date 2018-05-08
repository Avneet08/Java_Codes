 package Practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Reader1 {
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


class Node{
	
	Node left;
	Node right;
	int key,height;

	Node(int data){
		height=1;
		left=null;
		right=null;
		key=data;
	}
	
}
public class AVL_Tress {
 public Node root;
 int height(Node node){
	 if(node==null)return 0;
	 return node.height;
 }
 int Balancefac(Node node){
	 if(node==null){
		 return 0;}
	 
	return height(node.left)-height(node.right);
	 }
 int max(int a,int b){
	 if(a>b)return a;
	 else return b;
 }
 Node leftrotate(Node y){
	 Node x=y.left;
	 Node temp=x.right;
	 x.right=y;
	 y.left=temp;
	// update height
	 y.height = max(height(y.left), height(y.right)) + 1;
     x.height = max(height(x.left), height(x.right)) + 1;

     // Return new root
     return x;
 }
 Node rightrotate(Node y){
	 Node x=y.right;
	 Node temp=x.left;
	 x.left=y;
	 y.right=temp;
	 y.height = max(height(y.right), height(y.left)) + 1;
     x.height = max(height(x.right), height(x.left)) + 1;

     // Return new root
     return x;
 }
 public Node insert(Node root,int data){
	 if(root==null){
		 Node nptr=new Node(data);
		 return nptr;
	 }
	 if(data<root.key){
		 root.left=insert(root.left,data);
		 }
	 else if(data>root.key){
		 root.right=insert(root.right,data);
	 }
	 else
		 return root;
	 root.height = 1 + max(height(root.left), height(root.right));
	 int balance = Balancefac(root);
	 if (balance > 1 && data < root.left.key)
         return rightrotate(root);

     // Right Right Case
     if (balance < -1 && data > root.right.key)
         return leftrotate(root);

     // Left Right Case
     if (balance > 1 && data > root.left.key) {
         root.left = leftrotate(root.left);
         return rightrotate(root);
     }

     // Right Left Case
     if (balance < -1 && data < root.right.key) {
         root.right = rightrotate(root.right);
         return leftrotate(root);
     }

     /* return the (unchanged) node pointer */
     return root;
 }
 void preOrder(Node node) {
     if (node != null) {
         System.out.print(node.key + " ");
         preOrder(node.left);
         preOrder(node.right);
     }
 }
 Node minValueNode(Node node)
 {
     Node current = node;

     /* loop down to find the leftmost leaf */
     while (current.left != null)
        current = current.left;

     return current;
 }

 Node deleteNode(Node root, int key)
 {
     // STEP 1: PERFORM STANDARD BST DELETE
     if (root == null)
         return root;

     // If the key to be deleted is smaller than
     // the root's key, then it lies in left subtree
     if (key < root.key)
         root.left = deleteNode(root.left, key);

     // If the key to be deleted is greater than the
     // root's key, then it lies in right subtree
     else if (key > root.key)
         root.right = deleteNode(root.right, key);

     // if key is same as root's key, then this is the node
     // to be deleted
     else
     {

         // node with only one child or no child
         if ((root.left == null) || (root.right == null))
         {
             Node temp = null;
             if (temp == root.left)
                 temp = root.right;
             else
                 temp = root.left;

             // No child case
             if (temp == null)
             {
                 temp = root;
                 root = null;
             }
             else   // One child case
                 root = temp; // Copy the contents of
                              // the non-empty child
         }
         else
         {

             // node with two children: Get the inorder
             // successor (smallest in the right subtree)
             Node temp = minValueNode(root.right);

             // Copy the inorder successor's data to this node
             root.key = temp.key;

             // Delete the inorder successor
             root.right = deleteNode(root.right, temp.key);
         }
     }

     // If the tree had only one node then return
     if (root == null)
         return root;

     // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
     root.height = max(height(root.left), height(root.right)) + 1;

     // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
     //  this node became unbalanced)
     int balance = Balancefac(root);

     // If this node becomes unbalanced, then there are 4 cases
     // Left Left Case
     if (balance > 1 && Balancefac(root.left) >= 0)
         return rightrotate(root);

     // Left Right Case
     if (balance > 1 && Balancefac(root.left) < 0)
     {
         root.left = leftrotate(root.left);
         return rightrotate(root);
     }

     // Right Right Case
     if (balance < -1 && Balancefac(root.right) <= 0)
         return leftrotate(root);

     // Right Left Case
     if (balance < -1 && Balancefac(root.right) > 0)
     {
         root.right = rightrotate(root.right);
         return leftrotate(root);
     }

     return root;
 }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try {
			int MAXN = Reader.nextInt();
			int n = Reader.nextInt();
			
			AVL_Tress b=new AVL_Tress();
			for (int i=0; i<MAXN; i++) {
				b.insert(b.root,Reader.nextInt());
				 
			}
			for (int i=0; i<n; i++) {
				 
				 int userin = Reader.nextInt();
					if (userin == 2 ){
						b.preOrder(b.root);
						System.out.println("");
					}
					else if (userin==1){
						int query = Reader.nextInt();
						b.root = b.deleteNode(b.root,query);
					} 
			}
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	}


