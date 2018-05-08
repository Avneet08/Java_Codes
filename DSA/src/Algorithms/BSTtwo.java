package Algorithms;
import java.util.*;
class NodeX{
	int data;
	//NodeX Root;
	NodeX left;
	NodeX right;
	int key;
	NodeX(){
		this.data=0;
		left=null;
		right=null;
	}
	NodeX(int data){
		this.data=data;
		left=null;
		right=null;
		key=data;
	}
	
}

public class BSTtwo {
	public static  NodeX root;
	 public static int max=0;
	public BSTtwo(){
		this.root = null;
	}
	public int count (NodeX root) {
		  if (root==null)
	                   return 0;
	             else   
		         return 1 + count (root.left) + count (root.right);
		}
	public void swap(NodeX root) {
		//if(root == null){return null;}
		NodeX x = root;
		while(x.left != null) {
		x = x.left; }
		int temp = root.data;
		root.data = x.data;
		x.data = temp;
		}
public void rightview(NodeX node,int level){
	
	if(node==null)return;
	if(max<level){
		System.out.print(" "+node.data);
		max=level;
	}
	rightview(node.right,level+1);
	rightview(node.left,level+1);
	
	
}
public void Display(NodeX root){
	if(root!=null){
		System.out.print(" "+root.data);
		Display(root.left);
		Display(root.right);
		
	}
}
public void insert(int id){
	NodeX newNode2 = new NodeX(id);

	if(root==null){
		root = newNode2;
		return;
	}
	NodeX current = root;
	NodeX parent = null;
	while(true){
		parent = current;
		if(id<current.data){				
			current = current.left;
			if(current==null){
				parent.left = newNode2;
				return;
			}
		}else{
			current = current.right;
			if(current==null){
				parent.right = newNode2;
				return;
			}
		}
	}
}
public boolean searchBST (NodeX root, int target) {
    NodeX current = root;
    while (current != null) {
	if (current.data == target)
		return true;
	else if (current.data > target)
		return searchBST (current.left, target);
	else
         return searchBST (current.right, target);
		
    }
    return false;
}
public NodeX search (NodeX root, int target) {
    NodeX current = root;
    while (current != null) {
	if (current.data == target)
		return current;
	else if (current.data > target)
		return search (current.left, target);
	else
     return search (current.right, target);
		
    }
    return null;
}
public int smallest (NodeX root) {
    if (root.left == null)
          return (root.data);
          else 
                return smallest (root.left);
}
public int largest (NodeX root) {
    if (root.right == null)
          return (root.data);
          else 
                return largest (root.right);
}

public NodeX insert (NodeX root, int value) {
    if (root == null)
          root = new NodeX (value);
          else {
                if (value < root.data)
                      root.left = insert (root.left, value);
                else
                      root.right = insert (root.right, value);
           }
           return root;
 }
 NodeX delete(NodeX root,int id){
	NodeX parent = root;
	NodeX current = root;
	boolean isLeftChild = false;
	while(current.data!=id){
		parent = current;
		if(current.data>id){
			isLeftChild = true;
			current = current.left;
		}else{
			isLeftChild = false;
			current = current.right;
		}
		if(current ==null){
			return null;
		}
	}
	//if i am here that means we have found the node
	//Case 1: if node to be deleted has no children
	if(current.left==null && current.right==null){
		if(current==root){
			root = null;
		}
		if(isLeftChild ==true){
			parent.left = null;
		}else{
			parent.right = null;
		}
	}
	//Case 2 : if node to be deleted has only one child
	else if(current.right==null){
		if(current==root){
			root = current.left;
		}else if(isLeftChild){
			parent.left = current.left;
		}else{
			parent.right = current.left;
		}
	}
	else if(current.left==null){
		if(current==root){
			root = current.right;
		}else if(isLeftChild){
			parent.left = current.right;
		}else{
			parent.right = current.right;
		}
	}else if(current.left!=null && current.right!=null){
		
		//now we have found the minimum element in the right sub tree
		int successor	 = minValue(current.right);
		current.data=successor;
		current.right=delete (current.right, successor);
		/*if(current==root){
			root.data = successor;
		}else if(isLeftChild){
			parent.left.data = successor;
		}else{
			parent.right.data = successor;
		}			
		successor= current.left.data;*/
	}		
	return root;		
}
int minValue(NodeX root)
{     
    int minv = root.key;
    while (root.left != null)
    {
        minv = root.left.key;
        root = root.left;
    }
    return minv;
}
/*public NodeX getSuccessor(NodeX deleleNode){
	NodeX successsor =null;
	NodeX successsorParent =null;
	NodeX current = deleleNode.right;
	while(current!=null){
		successsorParent = successsor;
		successsor = current;
		current = current.left;
	}
	//check if successor has the right child, it cannot have left child for sure
	// if it does have the right child, add it to the left of successorParent.
//	successsorParent
	if(successsor!=deleleNode.right){
		successsorParent.left = successsor.right;
		successsor.right = deleleNode.right;
	}
	return successsor;
}*/
/*public int countLeafNodes() 
{ if (root == null) { return 0; } 
//Stacky stack = new Stacky(); 
stack.push(root); 
int count = 0; 
while (!stack.isEmpty()) { 
	NodeX node = stack.pop();
	if (node.left != null) 
		stack.push(node.left); 
	//count++;
	if (node.right != null) 
		stack.push(node.right); 
	count++;
	
}//if (node.left==null) count++; } 
return count; 

} */




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTtwo b=new BSTtwo();
		b.insert(7);
		b.insert(2);
		b.insert(1);
		b.insert(4);
				b.insert(3);b.insert(5);b.insert(6);b.insert(9);b.insert(8);
		//System.out.println("Original Tree : ");
		//b.Display(b.root);
		//System.out.println("");
		//b.delete(root,2);
		/*b.Display(root);
		System.out.println('\n');*/
		//System.out.println(b.count(root.right)); 
		//System.out.println(b.count(root.left)); 
		b.rightview(root,max+1);
		System.out.println('\n');
		b.delete(root,8);
		b.Display(root);
		System.out.println('\n');
		b.rightview(root,max+1);
		
		
		/*System.out.println(b.searchBST(root,25)); 
		System.out.println(b.search(root,25)); 
		System.out.println(b.smallest(root));
		System.out.println(b.largest(root));
		System.out.println(b.insert(root,30)); 
		//System.out.println(b.searchBST(root,30)); 
		b.delete(4);
		b.Display(root);*/
		//b.swap(root);
		//System.out.println(b.countLeafNodes());
		//System.out.println(b.count(root)); 
		//b.Display(root);
		
	}

}
