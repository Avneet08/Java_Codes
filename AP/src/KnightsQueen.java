import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



class stackEmptyException extends Exception{
	public	stackEmptyException(String	message)	{	
		super(message);	
		}
}
class KnightSamePositionException extends Exception{
	public	KnightSamePositionException(String	message)	{	
		super(message);	
		}
}
class NotCoordinateException extends Exception{
	public	NotCoordinateException(String	message)	{	
		super(message);	
		}
}
class FoundQueenException extends Exception{
	public	FoundQueenException(String	message)	{	
		super(message);	
		}
}
class knight{
	String name;
	int x,y;
	int m;
	ArrayList values;
	knight(String n,int x,int y,int m){
		this.name=n;
		this.x=x;
		this.y=y;
		this.m=m;
		values = new ArrayList<String>();
	}
	public void add(Object s) {
		values.add(s);
	}
	public static Comparator<knight> NameComparator = new Comparator<knight>() {

		public int compare(knight s1, knight s2) {
		   String Name1 = s1.getname().toUpperCase();
		   String Name2 = s2.getname().toUpperCase();
		   return Name1.compareTo(Name2);

	    }};
	    public int[] checktype(Object temp)throws NotCoordinateException, stackEmptyException {
	    	if(temp instanceof Integer) {
				
				throw new NotCoordinateException("NonCoordinateException: Not a coordinate Exception " +temp);
			}
			else if(temp instanceof String) {
				throw new NotCoordinateException("NonCoordinateException: Not a coordinate Exception " +temp);
			}
			else if(temp instanceof Float) {
				throw new NotCoordinateException("NonCoordinateException: Not a coordinate Exception " +temp);
			}
			else {
				System.out.println("No Exception "+x+" "+y);
				return move((coordinate)temp);
				
			}
	    }
	public int[] taketurn() throws NotCoordinateException, stackEmptyException {
		if(this.values.size()>0)
		{
			Object temp = this.values.get(0);
			this.values.remove(0);
			System.out.println(" "+name+" "+this.x+" "+this.y);
			
			return checktype(temp);
		}
		else {
			//System.out.println(" "+name+" "+this.x+" "+this.y);
			throw new stackEmptyException("StackEmptyException: Stack Empty exception");
		}
	}
	protected String getname() {
		// TODO Auto-generated method stub
		return this.name;
	}
	private int[] move(coordinate x) {
		this.x=x.x;
		this.y=x.y;
		int temp[] = new int[2];
		temp[0]=x.x;
		temp[1]=x.y;
		System.out.println("No Exception "+temp[0]+" "+temp[1]);
		return temp;
	}
	public String toString() {
		return this.name;
	}
	public void check(knight knight) throws KnightSamePositionException {
		if(knight.x==this.x && knight.y==this.y && !knight.toString().equals(this.toString()))
		{
			throw new KnightSamePositionException("knight " +knight + "at same position as of knight "+this.toString()+" removing knight" +knight);
		}
	}
}

class coordinate{
	public int x;
	public int y;
	coordinate(int a,int b){
		this.x=a;
		this.y=b;
	}
}
public class KnightsQueen {

	public static void main(String[] args) throws IOException, FoundQueenException {
		ArrayList<String> temp ;
		BufferedReader br = null;
		Scanner sc = new Scanner(System.in);
		int numKnight=0,in=0,queen_x=0,queen_y=0;
		numKnight = sc.nextInt();
		in = sc.nextInt();
		queen_x = sc.nextInt();
		queen_y = sc.nextInt();
		ArrayList<knight> stack = new ArrayList<knight>();
		String t[]=new String[2];
		
		for(int i = 0;i<numKnight;i++) {
			br = new BufferedReader(new FileReader("C:\\Users\\avnee\\Downloads\\lab6-ece-cseandcsam_13559\\Lab 6\\Test Case\\Input\\" + (i+1) + ".txt"));
			temp =  new ArrayList<String>();
			String sCurrentLine;
			for(int j=0;j<3;j++) {
				sCurrentLine = br.readLine();
				temp.add(sCurrentLine);
			}
			t=temp.get(1).split(("\\s"));
			knight k=new knight(temp.get(0),Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(temp.get(2)));
			stack.add(k);
			Collections.sort(stack, knight.NameComparator);
			for(int j=0;j<Integer.parseInt(temp.get(2));j++) {
				sCurrentLine = br.readLine();
				
				String temp2[];
				temp2=sCurrentLine.split(("\\s"));
				if(temp2[0].equals("String")) {
					stack.get(i).add(new String(temp2[1]));	
				}
				else if(temp2[0].equals("Integer")) {
					stack.get(i).add(new Integer(temp2[1]));
				}
				else if(temp2[0].equals("Coordinate")) {
					stack.get(i).add(new coordinate(Integer.parseInt(temp2[1]),Integer.parseInt(temp2[2])));
				}
				else if(temp2[0].equals("Float")) {
					stack.get(i).add(new Float(temp2[1]));
				}
			}
		}
		int it_no=0;
		int  ncor[]=new int[2];
		while(it_no<in || numKnight<1) {
			for(int i = numKnight;i<=0;i--) {
			try{
				try {
					ncor = stack.get(i).taketurn();}
				catch(NotCoordinateException e){
					System.out.println(e.getMessage());}
				}
			catch(stackEmptyException e) {
				System.out.println(e.getMessage());
				stack.remove(i);
				numKnight=numKnight-1;
				continue;}
			
				if(ncor[0]==queen_x && ncor[1]==queen_y) {
					try {
						throw new FoundQueenException("Queen has been found . Abort!");
					}
					catch(FoundQueenException e) {
						System.out.println(e.getMessage());
						System.exit(0);
					}
				}
			else {
					for(int j=0;j<numKnight;j++) {
						try{
							stack.get(i).check(stack.get(j));}
						catch(Exception e){
							System.out.println(e.getMessage());
							stack.remove(j);
							numKnight=numKnight-1;
						}
					}
				}
			}
			
			
			}
		}

}

