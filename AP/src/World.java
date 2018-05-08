import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

	

abstract class Animal  {
	Random rand=new Random();
	int x;
	int y;
	int t_timestamp;
	int time;
	int health;
	Grassland g1;
	Grassland g2;
	
	 Animal(int x,int y,int time,int health,Grassland g1,Grassland g2){
		this.x=x;
		this.y=y;
		
		this.time=time;
		this.health=health;
		this.g1=g1;
		this.g2=g2;
		
	}
	public int gettime(){
		return this.time;
	}
	public int gethealth(){
		return this.health;
	}
	public int getx(){
		return this.x;
	}
	public int gety(){
		return this.y;
	}
	protected int checkGrassland( ){
		int c;
		if((x-g1.x)*(x-g1.x)+(y-g1.y)*(y-g1.y)<=g1.r*g1.r){
			c=1;
		}
		else if((x-g2.x)*(x-g2.x)+(y-g2.y)*(y-g2.y)<=g2.r*g2.r){
			c=2;
		}
		
		else{
			c=0;
		}
		return c;
	}
	protected int checkcarrad(int h_x,int h_y,int rad){
		int c=0;
		 if((x-h_x)*(x-h_x)+(y-h_y)*(y-h_y)<=rad*rad){
			c=1;
		}
		
		else{
			c=0;
		}
		return c;
	}
	public float getLength(int x1,int y1,int gx1,int gy1){
		float length=0;
		length= (float) Math.sqrt(Math.pow((gx1-x1),2)+Math.pow((gy1-y1),2));
		return length;
		
	}
	public void getcoor(int units,float d1,float d2){
		int fy;
		int fx;
		if(d1>d2){
			 fx=g1.x;
			 fy=g1.y;
		}else{
			fx=g2.x;
			fy=g2.y;
		}
		setnewcoor(fx,fy,units);
	}
	public void setnewcoor(int fx,int fy,int units){
		float setRotation=((float) Math.toDegrees(Math.atan2(fy - y, fx - x)) + 90);
		float xDirection = (float) (Math.sin((float) Math.toRadians(setRotation))
	            * units);
		float yDirection = (float) (Math.cos((float) Math.toRadians(setRotation))
	            * -units);

	 x = (int) (x + xDirection);
	 y = (int) (y + yDirection);
	}
	float[] getdistcar(ArrayList<Animal> al){
		float[] d5=new float[5];
		for(int i=0;i<al.size();i++){
			if(!al.get(i).getgcf()){
				d5[i]=getLength(x,y,al.get(i).x,al.get(i).y);
			}
		}
		return d5;
	}
	float[] getdisther(ArrayList<Animal> al){
		float[] d5=new float[5];
		for(int i=0;i<al.size();i++){
			if(al.get(i).getgcf()){
				d5[i]=getLength(x,y,al.get(i).x,al.get(i).y);
			}
		}
		return d5;
	}
	public abstract boolean getgcf();
	public abstract int move(int count,ArrayList<Animal> al);
	public void setnewtime(int d) {
		this.time=d;
		
	}
	public abstract String getname();
}
class Herbivore extends Animal{
int gc;
int id;
int cout;
boolean gcf=true;
	public Herbivore(int x, int y,  int time, int health, int gc,Grassland g1,Grassland g2,int id) {
		super(x, y,  time, health, g1, g1);
		this.gc=gc;
		this.id=id;
		// TODO Auto-generated constructor stub
	}
	public String name;
	private void nameset(){
	if(id==1){
		name="First Herbivore ";
	}else{
		name="Second Herbivore ";
	}
	}
	
	@Override
	public boolean getgcf(){
		return this.gcf;
	}
	public String getname(){
		nameset();
		return this.name;
	}
	public int move(int count,ArrayList<Animal> al){
		t_timestamp++;
		float d1=getLength(x,y,g1.x,g1.y);
		float d2=getLength(x,y,g2.x,g2.y);
		
		if(count<1){
			if(checkGrassland()==0){
				cout++;
				if(cout>6){
					health=health-5;
				}
				int c=rand.nextInt(100);
				if(c>51){
					System.out.println("loof");
					health=health-25;
					getcoor(5,d1,d2);
				}	
			}
			else{
				getcoor(5,d1,d2);
			}
			
			
		}
		else{
			if(checkGrassland()==0){
				cout++;
				if(cout>6){
					health=health-5;
				}
				int c=rand.nextInt(100);
				if(c>=6){
					
					int d=rand.nextInt(100);
					if(c<65){
						
						getcoor(5,d1,d2);
					}
					else{
						float[] all;
						all=getdistcar(al);
						getcoor(-4,all[0],all[1]);
					}
				}
				
				}
			else if(checkGrassland()==1){
				if(g1.grass>=gc){
					int c=rand.nextInt(100);
					if(c<=90){
						g1.grass-=gc;
						//health-=25;
						health+=health/2;
					}
					else {
						health-=25;
						int d=rand.nextInt(100);
						if(d<=50){
							float[] all;
							all=getdistcar(al);
							getcoor(-2,all[0],all[1]);
						}else{
							setnewcoor(g2.x,g2.y,3);
						}
					}
				}
				else{
					int c=rand.nextInt(100);
					if(c<=20){
						g1.grass=0;
						health+=(health*0.2);
					}else{
						health-=25;
						int d=rand.nextInt(100);
						if(d<=70){
							float[] all;
							all=getdistcar(al);
							getcoor(-4,all[0],all[1]);
						}else{
							setnewcoor(g2.x,g2.y,2);
						}
					}
				}
			}
			else{
				if(g2.grass>=gc){
					int c=rand.nextInt(100);
					if(c<=90){
						g2.grass-=gc;
					}
					else {
						int d=rand.nextInt(100);
						if(d<=50){
							float[] all;
							all=getdistcar(al);
							getcoor(-2,all[0],all[1]);
						}else{
							setnewcoor(g1.x,g1.y,3);
						}
					}
				}
				else{
					int c=rand.nextInt(100);
					if(c<=20){
						
						g2.grass=0;
					}else{
						int d=rand.nextInt(100);
						if(d<=70){
							float[] all;
							all=getdistcar(al);
							getcoor(-4,all[0],all[1]);
						}else{
							setnewcoor(g1.x,g1.y,2);
						}
					}
				}
			}
		}
		return t_timestamp;
	}
	
}
 class Carnivore extends Animal{
	 int id; 
	 
	 boolean gcf=false;
	public Carnivore(int x, int y, int time, int health,Grassland g1,Grassland g2,int id) {
		super(x, y, time, health, g2, g2);
		this.id=id;
		// TODO Auto-generated constructor stub
	}
	public String name;
	private void nameset(){
	if(id==1){
		name="First Carnivore ";
	}else{
		name="Second Carnivore ";
	}
	}
	@Override
	public boolean getgcf(){
		return this.gcf;
	}
	public String getname(){
		nameset();
		return this.name;
	}
	public int move(int count,ArrayList<Animal> al){
		t_timestamp++;
	if(count >0){
		for(int i=0;i<al.size();i++){
			
			if(al.get(i).getgcf() && checkcarrad(al.get(i).getx(),al.get(i).gety(),1)!=0){
				health=health+al.get(i).gethealth()*(2/3);
				al.remove(i);
				
				break;
			}	
		}
		if(checkGrassland()==0){
			int c=rand.nextInt(100);
			if(c<=92){
				float[] all;
				all=getdisther(al);
				getcoor(4,all[0],all[1]);
			}else{
				health=health-60;
			}
		}else{
			int c=rand.nextInt(100);
			if(c>25){
				float[] all;
				all=getdisther(al);
				getcoor(2,all[0],all[1]);
			}else{
				health=health-30;
			}
		}
		
	}
	return t_timestamp;
	}
	
}
class Grassland{
	int x;
	int y;
	int r;
	int grass;
	Grassland(int x, int y, int r, int grass){
		this.x=x;
		this.y=y;
		this.r=r;
		this.grass=grass;
		
	}
}
public class World {
	public static int T_time;
	public static int x_1;
	public static int y_1;
	public static int r_1;
	public static int GA_1;
	public static int x_2;
	public static int y_2;
	public static int r_2;
	public static int GA_2;
	public static int Health_h;
	public static int GC_h;
	public static int Health_c;
	public static int x_1_h;
	public static int y_1_h;
	public static int time_1_h;
	public static int x_2_h;
	public static int y_2_h;
	public static int time_2_h;
	public static int x_1_c;
	public static int y_1_c;
	public static int time_1_c;
	public static int x_2_c;
	public static int y_2_c;
	public static int time_2_c;
	public static int hcount;
	public static int ccount;
	
	static double dist(int x1,int x2,int y1,int y2){
		double dis=Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
		return dis;
	}
	static ArrayList<Animal> sort(ArrayList<Animal> al){
		for (int i = 0; i < al.size() - 1; i++)  
        {  
           
            for (int j = i + 1; j < al.size(); j++){  
            	Animal tmp=null;
                if ( al.get(i).gettime() >( al.get(j)).gettime()){  
                	tmp = al.get(i);
	                  al.set(i,al.get(j));
	                  al.set(j,tmp);
                  break; 
                    
                }  
                else if(( al.get(i)).gettime() ==( al.get(j)).gettime()){
                	if(( al.get(i)).gethealth()>( al.get(i)).gethealth()){
                			tmp = al.get(i);
      	                  al.set(i,al.get(j));
      	                  al.set(j,tmp);
                        break;	
                	}
                	
                	else if(( al.get(i)).gethealth()==( al.get(i)).gethealth()){
                		Animal a= al.get(i);
        				Animal b= al.get(j);
                		if(( al.get(i)).getgcf()){
                			if(( al.get(j)).getgcf()){
                				
                				if(dist(0,a.getx(),0,a.gety())>dist(0,b.getx(),0,b.gety())){
                					tmp = al.get(i);
              	                  al.set(i,al.get(j));
              	                  al.set(j,tmp);
                               
                				}
                			}
                			else{
                				tmp = al.get(i);
            	                  al.set(i,al.get(j));
            	                  al.set(j,tmp);
                              break;	
                			}
                		}
                		else{
                			if(( al.get(j)).getgcf()){
                				tmp = al.get(i);
          	                  al.set(i,al.get(j));
          	                  al.set(j,tmp);
                            break;
                			}
                			else{
                				if(dist(0,a.getx(),0,a.gety())>dist(0,b.getx(),0,b.gety())){
                					tmp = al.get(i);
              	                  al.set(i,al.get(j));
              	                  al.set(j,tmp);
                                
                				}
                			}
                		}
                	}
                }
            }  
            
        }  
		return al;
	}
	public static void checkcount(ArrayList<Animal> al){
		for(int i=0;i<al.size();i++){
			if(al.get(i).getgcf()){
				hcount++;
			}
			else{
				ccount++;
			}
		}
	}
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		System.out.println("Enter Total Final Time for Simulation:");
		T_time=Reader.nextInt();
		System.out.println("Enter x, y centre, radius and Grass Available for First Grassland:");
		x_1=Reader.nextInt();
		y_1=Reader.nextInt();
		r_1=Reader.nextInt();
		GA_1=Reader.nextInt();
		System.out.println("Enter x, y centre, radius and Grass Available for Second Grassland:");
		x_2=Reader.nextInt();
		y_2=Reader.nextInt();
		r_2=Reader.nextInt();
		GA_2=Reader.nextInt();
		System.out.println("Enter Health and Grass Capacity for Herbivores:");
		Health_h=Reader.nextInt();
		GC_h=Reader.nextInt();
		System.out.println("Enter x, y position and timestamp for First Herbivore:");
		x_1_h=Reader.nextInt();
		y_1_h=Reader.nextInt();
		time_1_h=Reader.nextInt();
		System.out.println("Enter x, y position and timestamp for Second Herbivore:");
		x_2_h=Reader.nextInt();
		y_2_h=Reader.nextInt();
		time_2_h=Reader.nextInt();
		System.out.println("Enter Health for Carnivores:");
		Health_c=Reader.nextInt();
		System.out.println("Enter x, y position and timestamp for First Carnivore:");
		x_1_c=Reader.nextInt();
		y_1_c=Reader.nextInt();
		time_1_c=Reader.nextInt();
		System.out.println("Enter x, y position and timestamp for Second Carnivore:");
		x_2_c=Reader.nextInt();
		y_2_c=Reader.nextInt();
		time_2_c=Reader.nextInt();
		Grassland g1=new Grassland(x_1,y_1, r_1,GA_1);
		Grassland g2=new Grassland(x_2,y_2, r_2,GA_2);
		Herbivore h1=new Herbivore(x_1_h, y_1_h, time_1_h,Health_h,GC_h,g1,g2,1);
		Herbivore h2=new Herbivore(x_2_h, y_2_h, time_2_h,Health_h,GC_h,g1,g2,2);
		Carnivore c1=new Carnivore(x_1_c, y_1_c, time_1_c,Health_c,g1,g2,1);
		Carnivore c2=new Carnivore(x_2_c, y_2_c, time_2_c,Health_c,g1,g2,2);
		System.out.println("The Simulation Begins -");
		ArrayList<Animal> al=new ArrayList<Animal>();
		al.add(h1);al.add(c2);	al.add(c1);	al.add(h2);
		sort(al);
		
		int i=0;
		Animal animal;
		while(al.size()!=0 || T_time!=0){
			checkcount(al);
			if(i<al.size()){
			if(al.get(i).getgcf()){
				System.out.println(al.get(i).getname());
				T_time-=al.get(i).move(ccount,al);
				//System.out.println("Its health after taking turn is "+al.get(i).gethealth() );
				Animal c=al.remove(i);
				if(c.gethealth()>0){
					System.out.println("Its health after taking turn is "+c.gethealth() );
					Random rand=new Random();
					int d=rand.nextInt(T_time-c.gettime())+c.gettime();
					c.setnewtime(d);
					System.out.println(c.gettime());
					al.add(c);
				}else{
					System.out.println("It is dead");
					continue;
				}
				
			}
			else{
				System.out.println(al.get(i).getname());
				
				T_time-=al.get(i).move(hcount,al);
				
				Animal c=al.remove(i);
				if(c.gethealth()>0){
					System.out.println("Its health after taking turn is "+c.gethealth() );
					Random rand=new Random();
					int d=rand.nextInt(T_time-c.gettime())+c.gettime();
					
					c.setnewtime(d);
					System.out.println(c.gettime());
					al.add(c);
				}else{
					System.out.println("It is dead");
					continue;
				}
			}
			}
			i++;		}
		
	
		
		
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