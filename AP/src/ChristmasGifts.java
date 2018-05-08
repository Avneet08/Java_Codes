import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

//import javax.xml.soap.Node;

 class BST <T extends Comparable<T>>
{ ArrayList<T> io=new ArrayList<T>();
	  class Node<T> {
	        T key;
	        Node left, right;
	 
	        public Node(T item) {
	            key = item;
	            left = right = null;
	        }
	    }
	  private Node<T> root;

   private Comparator<T> comparator;

   public BST()
   {
      root = null;
      comparator = null;
   }

   public BST(Comparator<T> comp)
   {
      root = null;
      comparator = comp;
   }

   private int compare(T x, T y)
   {
      if(comparator == null) return x.compareTo(y);
      else
      return comparator.compare(x,y);
   }


   public void insert(T data)
   {
      root = insert(root, data);
   }
   private Node<T> insert(Node<T> p, T toInsert)
   {
      if (p == null)
         return new Node<T>(toInsert);

      if (compare(toInsert, p.key) == 0)
      	return p;

      if (compare(toInsert, p.key) < 0)
         p.left = insert(p.left, toInsert);
      else
         p.right = insert(p.right, toInsert);

      return p;
   }
   public void preOrderTraversal()
   {
      preOrderHelper(root);
   }
   private void preOrderHelper(Node<T> r)
   {ArrayList<T> po=new ArrayList<T>();
      if (r != null)
      {po.add(r.key);
         //System.out.print(r+" ");
         preOrderHelper(r.left);
         preOrderHelper(r.right);
      }
   }

   public int inOrderTraversal(int a)
   {int rootc = 0;
   
      inOrderHelper(root);
      for(int i=0;i<io.size();i++){
    	  if(compare(io.get(i),root.key)==0){
    		rootc=i;  
    	  }
      }
      
      return rootc;
   }
   
   /*private void inOsum(){
	  T sum;
	  for(T teams:io){
		sum=sum.doublevalue()+teams.doublevalue();  
	  }
   }*/
   private void inOrderHelper(Node<T> r)
   {
	  
      if (r != null)
      {
         inOrderHelper(r.left);
         io.add(r.key);
         //System.out.print(r+" ");
         inOrderHelper(r.right);
      }
   }


   }
class Arrayl<T>{
	String type;
	int no;
	
	ArrayList<T> ne;
	Arrayl(String type,int no){
		this.type=type;
		this.no=no;
		
		ne=new ArrayList<T>();
		
	}
	public void add(T o){
		ne.add(o);
	}
	public T get(int i){
		return ne.get(i);
	}
	public String gettype() {
		
		return this.type;
	}
	public int size() {
		
		return ne.size();
	}
	public void print(){
		for(int i=0;i<ne.size();i++){
			System.out.println(ne.get(i));
		}
	}
	
}
public class ChristmasGifts {
	//private BST<> bst;
	private ArrayList<Integer> fl;
	public void maketree(ArrayList<Arrayl> al){
		fl=new ArrayList<Integer>();
		for(int i=0;i<al.size();i++){
			al.get(i).get(0).getClass();
			for(int j=0;j<al.size();j++){
				//Object ao= al.get(i).get(j);
				if(al.get(i).gettype().equals("Integer")){
					BST<Integer> bst = new BST<Integer>();
					bst.insert((Integer) al.get(i).get(j));
					fl.add(bst.inOrderTraversal(0));
					
				}
				else if(al.get(i).gettype().equals("String")){
					BST<String> bst = new BST<String>();
					bst.insert((String) al.get(i).get(j));
					fl.add(bst.inOrderTraversal(2));
				}
				else{
					BST<Float> bst = new BST<Float>();
					bst.insert((Float) al.get(i).get(j));
					fl.add(bst.inOrderTraversal(3));
				}
			}
		}
	}
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		System.out.println("Enter the stusents and the trees");
		int Students=Reader.nextInt();
		int trees=Reader.nextInt();
		BufferedReader br = null;
		FileReader fr = null;
		ArrayList <Arrayl> ne=new ArrayList <Arrayl>();
		for (int i = 1; i <= trees; i++) {
			String Filename="C:\\Users\\avnee\\Downloads\\lab5-ece-cseandcsam_13371\\lab5\\TEST_CASES\\T1\\input\\"+i+".txt";
			fr = new FileReader(Filename);
			br = new BufferedReader(fr);
			
			String type=br.readLine();
			int c=br.read();
			String s=br.readLine();
			
			while ((s=br.readLine()) != null) {
			if(type.equals("String")){
				//System.out.println(s);
				
				Arrayl<String> datas =new Arrayl<String>(type,c);
				for(String word : s.split(" ")) {
					datas.add(word);
				}
			}
			else if(type.equals("Float")){
				Arrayl<Float> datas =new Arrayl<Float>(type,c);
				Arrayl<String> Sdatas = new Arrayl<String>(type,c);
				for(String word : s.split(" ")) {
					Sdatas.add(word);
				}
				for (int m = 0; m < Sdatas.size(); m++) {
			        float number = Float.parseFloat(Sdatas.get(m));
			        datas.add(number);
			    }
				System.out.println(datas); 
				
			}
			else if(type.equals("Integer")){
				//ArrayList <Integer> ob = new ArrayList <Integer>();
				Arrayl<Integer> datas = new Arrayl<Integer>(type,c);
				Scanner sc = new Scanner(s);
				while(sc.hasNextInt()){
				    datas.add(sc.nextInt());
				}
				System.out.println(datas);
				
			}
			
			}
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
