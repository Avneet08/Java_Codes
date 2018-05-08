import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
	

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
class NonCoordinateException extends Exception{
	public	NonCoordinateException(String	message)	{	
		super(message);	
		}
}
class FoundQueenException extends Exception{
	public	FoundQueenException(String	message)	{	
		super(message);	
		}
class Coordinate{
	int x;
	int y;
	Coordinate(int x,int y){
		this.x=x;
		this.y=y;
	}
	}
	class Knight{
		String name;
		Coordinate coor;
		ArrayList magicbox;
		Knight(String name,Coordinate coor,Stack magicbox){
			this.name=name;
			this.coor=coor;
			this.magicbox=magicbox;
		}
		 String getname(){
			return this.name;
		}
		 public static Comparator<Knight> NameComparator = new Comparator<Knight>() {

				public int compare(Knight s1, Knight s2) {
				   String Name1 = s1.getname().toUpperCase();
				   String Name2 = s2.getname().toUpperCase();
				   return Name1.compareTo(Name2);

			    }};
		public int getx() {
			return coor.getxp();
		}
		public void setx(int i) {
			coor.setxp(i);
			
		}
		
		public void sety(int i) {
			coor.setyp(i);
			
		}
		public int gety() {
			return coor.getyp();
			
		}
		public void play(ArrayList<Knight> players) throws NonCoordinateException {
			if(magicbox.peek().getClass()!=coor.getClass()){
				throw new NonCoordinateException("Not a coordinate Exception"+magicbox.pop());
			}
			else{
			}
		}
		
	}
public  class KnightsandQueen{
	protected static Coordinate Queencoor;
	protected static int numIter;
	
	public static void main(String[] args) throws IOException, FoundQueen {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		System.out.println("The ​ ​number​ ​of ​ ​knights​ ");
		int numKnights=Reader.nextInt();
		System.out.println("The ​ ​number​ ​of ​ iterations ");
		 numIter=Reader.nextInt();
		 int q_x=Reader.nextInt();
		 int q_y=Reader.nextInt();
		 Queencoor=new Coordinate(q_x,q_y);
		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<Knight> players=new ArrayList<Knight>();
		for (int i = 1; i <= numKnights; i++) {
			String Filename="C:\\Users\\avnee\\Downloads\\lab6-ece-cseandcsam_13559\\Lab 6\\Test Case\\Input\\"+i+".txt";
			fr = new FileReader(Filename);
			br = new BufferedReader(fr);
			String name=br.readLine();
			String co=br.readLine();
			//System.out.println(co);
			ArrayList<String> coordAr =new ArrayList<String>();
			for(String word : co.split(" ")) {
				coordAr.add(word);
			}
			
			Coordinate coor=new Coordinate(Integer.parseInt(coordAr.get(0)),Integer.parseInt(coordAr.get(1)));
			String m=br.readLine();
			ArrayList<String> store=new ArrayList<String>();
			  Stack<Object> stack = new Stack<Object>();
			  //System.out.println(m);
			for(int j=1;j<=Integer.parseInt(m);j++){
				String q=br.readLine();
				//System.out.println(j);
				ArrayList<String> datas =new ArrayList<String>();
				
				for(String word : q.split(" ")) {
					datas.add(word);
				}
				if(datas.get(0).equals("Integer")){
					
					stack.push(Integer.parseInt(datas.get(1)));
				}
				else if(datas.get(0).equals("Float")){
					stack.push(Float.parseFloat(datas.get(1)));
				}
				else if(datas.get(0).equals("Coordinate")){
					int x=Integer.parseInt(datas.get(1));
					int y=Integer.parseInt(datas.get(2));
					Coordinate c=new Coordinate(x,y);
					stack.push(c);
					
					}
				else if(datas.get(0).equals("String")){
					stack.push(datas.get(1));
				}
			}
			Knight k1=new Knight(name,coor,stack);
			players.add(k1);
			
			}
		Collections.sort(players, Knight.NameComparator);
		while(numIter!=0 ){
			for(int i=0;i<players.size();i++){
				players.get(i).play(players);
				numIter--;
			}
		}
		
		/*for(int i=0;i<players.size();i++){
			System.out.println(players.get(i).getname());
		}*/
		
		
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
