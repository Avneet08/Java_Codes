
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

class Creature{
	Random rand=new Random();
	protected int cost;
	protected int asset;
	protected int power;
	public int health;
	protected  String name;
	protected String type;
	void Damage(Creature c,int no){
		int n=rand.nextInt(no);
		c.health=c.health-n;
	}
	int getpower(){
		return this.power;
	}
	String getname() {
		// TODO Auto-generated method stub
		return this.name;
	}
	public int getasset() {
		// TODO Auto-generated method stub
		return this.asset;
	}
}
class Human extends Creature{
	Human(String name,int cost,int asset,int power,int health){
		this.name=name;
		this.cost=cost;
		this.asset=asset;
		this.power=power;
		this.health=health;
		this.type="Human";
	}
	
}
class Dragon extends Creature{
	@Override
	void Damage(Creature c,int power){
		int n=rand.nextInt(power+1);
		c.health=c.health-n;
		int nu=rand.nextInt(100+1);
		
		if(n<=15){
			c.health=c.health-25;
		}
	}
}
class Fire_Dragon extends Dragon{
	Fire_Dragon(String name,int cost,int asset,int power,int health){
		this.cost=cost;
		this.asset=asset;
		this.power=power;
		this.health=health;
		this.name=name;
		this.type="Fire_Dragon";
	}
}
class Ice_Dragon extends Dragon{
	Ice_Dragon(String name,int cost,int asset,int power,int health){
		this.cost=cost;
		this.asset=asset;
		this.power=power;
		this.health=health;
		this.name=name;
		this.type="Ice_Dragon";
	}
	@Override
	void Damage(Creature c,int ni){
		super.Damage(c,ni);
		int n=rand.nextInt(100+1);
		if(n<=5){
			int no=rand.nextInt(ni+1);
			c.health=c.health-no;
		}
	}
	
}
class Deamon extends Creature{
	Deamon(String name,int cost,int asset,int power,int health){
		this.cost=cost;
		this.asset=asset;
		this.power=power;
		this.health=health;
		this.name=name;
		this.type="Deamon";
	}
	@Override
	void Damage(Creature c,int nui){
		int n=rand.nextInt(nui);
		c.health=c.health-n;
		int nu=rand.nextInt(100+1);
		
		if(n<=50){
			c.health=c.health-n;
		}	
	}
	
}
class Wolves extends Creature{
	Wolves(String name,int cost,int asset,int power,int health){
		this.cost=cost;
		this.asset=asset;
		this.power=power;
		this.health=health;
		this.name=name;
		this.type="Wolves";
	}
	
}
class Team{
	int money;
	//public boolean isgood=true;
	int min;
	ArrayList<Creature> team=new ArrayList<Creature>();
	public boolean istrue=true;
	
}
public class Fantasy_Game extends Creature{
	public static int g_money;
	public static int b_money;
	public static int min_b;
	public static int min_g;
	public static int costh;
	public static int costid;
	public static int costfd;
	public static int costw;
	public static int costd;
	public static int asseth;
	public static int assetfd;
	public static int assetid;
	public static int assetw;
	public static int assetd;
	public static int powerh;
	public static int powerd;
	public static int powerw;
	public static int powerfd;
	public static int powerid;
	public static int healthh;
	public static int healthid;
	public static int healthfd;
	public static int healthw;
	public static int healthd;
	public static Team teamgood=new Team();
	public static Team teambad=new Team();
	 public static boolean goodplayer=false;
		public static boolean badplayer=false;
		public static int count=1;
		public static int g = 0;
		public static int k = 0;
	
public static void buycreature(Team a)throws IOException{
	Reader.init(System.in);
	if(a.istrue){
	while(g_money>=min_g){
		System.out.println("Select Creatures For Team Good:");
		System.out.println("1. Human");
		System.out.println("2. Fire Dragon");
		System.out.println("3. Wolf");
		System.out.println("4. Exit Selection");
		int userin=Reader.nextInt();
		switch (userin) {
        case 1:
        	g_money-=costh;
            System.out.println("Enter Name Of The Human -");
            String s=Reader.next();
            Human h=new Human(s,costh,asseth,powerh,healthh);
            teamgood.team.add(h);
            
            break;
        case 2:
        	g_money-=costfd;
          System.out.println("Enter Name Of The Fire Dragon -");
          String s1=Reader.next();
            Fire_Dragon hj=new Fire_Dragon(s1,costfd,assetfd,powerfd,healthfd);
            teamgood.team.add(hj);
            break;
        case 3:
        	g_money-=costw;
        	System.out.println("Enter Name Of The Wolf -");
        	String s2=Reader.next();
            Wolves hu=new Wolves(s2,costw,assetw,powerw,healthw);
            teamgood.team.add(hu);
            break;
        case 4:
            
            break;
        default:
            // The user input an unexpected choice.
    }
		System.out.println();
		
		}	
		
	}
	
	else{
		while(b_money>min_b){
			System.out.println("Select Creatures For Team Bad:");
			System.out.println("1. Daemons");
			System.out.println("2. Ice Dragon");
			System.out.println("3. Exit Selection");
			int userin=Reader.nextInt();
			switch (userin) {
	        case 1:
	        	b_money-=costd;
	            System.out.println("Enter Name Of The Daemons -");
	            String s2=Reader.next();
	            Deamon hu=new Deamon(s2,costd,assetd,powerd,healthd);
	        	teambad.team.add(hu);
	            break;
	        case 2:
	        	b_money-=costid;
	          System.out.println("Enter Name Of The Ice Dragon -");
	          String s3=Reader.next();
	            Ice_Dragon hum=new Ice_Dragon(s3,costid,assetid,powerid,healthid);
	            teambad.team.add(hum);
	            break;
	        
	        case 3:
	            
	            break;
	        default:
	            // The user input an unexpected choice.
	    }
			System.out.println();
	}
	}

}
static void checkHealth() throws IOException{
	System.out.println("Round:"+count);
	if(teamgood.team.get(g).health<0 && teambad.team.get(k).health<0){
		teamgood.team.remove(g);
		teambad.team.remove(k);
		System.out.println("both dies ");
		System.out.println("Money Of Bad’s Team is " + b_money);
		System.out.println("Money Of Good’s Team is " + g_money);
		buycreature(teamgood);
		buycreature(teambad);
		badplayer= false;
		goodplayer= false;
	}else if(teamgood.team.get(g).health<0 && teambad.team.get(k).health>0){
		teamgood.team.remove(g);
		b_money +=teambad.team.get(g).getasset();
		System.out.println("team bad won xD");
		System.out.println("Money Of Bad’s Team is " + b_money);
		System.out.println("Money Of Good’s Team is " + g_money);
		buycreature(teamgood);
		buycreature(teambad);
		badplayer= false;
	
	
	}else if(teamgood.team.get(g).health>0 && teambad.team.get(k).health<0){
		teambad.team.remove(k);
		System.out.println("team good won xD");	
		g_money += teamgood.team.get(k).getasset();
		System.out.println("Money Of Bad’s Team is " + b_money);
		System.out.println("Money Of Good’s Team is " + g_money);
		buycreature(teambad);
		buycreature(teamgood);
		goodplayer= false;
	}else if(teamgood.team.get(g).health>0 && teambad.team.get(k).health>0){
		
		System.out.println("Both alive,will continue in next round");
		System.out.println("Money Of Bad’s Team is " + b_money);
		System.out.println("Money Of Good’s Team is " + g_money);
		buycreature(teambad);
		buycreature(teamgood);
		
	}
	count++;
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try {
			System.out.println("Enter Team Good’s total money");
			  g_money = Reader.nextInt();
			System.out.println("Enter Team Bad’s total money");
			 b_money=Reader.nextInt();
			System.out.println("Enter cost, asset , power and health for Human (space-separated) -");
			 costh=Reader.nextInt();
			 asseth=Reader.nextInt();
			 powerh=Reader.nextInt();
			 healthh=Reader.nextInt();
			System.out.println("Enter cost, asset , power and health for Fire Dragon (space-separated) -");
			 costfd=Reader.nextInt();
			 assetfd=Reader.nextInt();
			 powerfd=Reader.nextInt();
			 healthfd=Reader.nextInt();
			System.out.println("Enter cost, asset , power and health for Ice Dragon (space-separated) -");
			 costid=Reader.nextInt();
			 assetid=Reader.nextInt();
			powerid=Reader.nextInt();
			 healthid=Reader.nextInt();
			System.out.println("Enter cost, asset , power and health for Daemon (space-separated) -");
			 costd=Reader.nextInt();
			 assetd=Reader.nextInt();
			 powerd=Reader.nextInt();
			 healthd=Reader.nextInt();
			System.out.println("Enter cost, asset , power and health for Wolf (space-separated) -");
			 costw=Reader.nextInt();
			 assetw=Reader.nextInt();
			 powerw=Reader.nextInt();
			 healthw=Reader.nextInt();
			
			
			
		 min_g=Math.min(costh, Math.min(costfd, costw));
		  min_b=Math.min(costid, costd);
		 buycreature(teamgood);
		 teambad.istrue=false;
		
		 buycreature(teambad);
			System.out.println("The War Begins -");
			
			while((teamgood.team.size()>0)&&(teambad.team.size()>0)){
				if(!goodplayer){
			System.out.println("Round "+count);
			System.out.println("Enter Creature from Good’s Team to fight in the war -");
			String name=Reader.next();
			
			
			
			for( int i=0;i<teamgood.team.size();i++){
				if(name.equals(teamgood.team.get(i).getname())){
				     g=i;	
				}
			}
			goodplayer=true;
				}
				if(!badplayer){
					
					System.out.println("Enter Creature from Bad’s Team to fight in the war -");
					String name2=Reader.next();
			for( int i=0;i<teambad.team.size();i++){
				if(name2.equals(teambad.team.get(i).getname())){
				     k=i;	
				}
			}
			badplayer=true;
				}
			
			teamgood.team.get(g).Damage(teambad.team.get(k),teambad.team.get(k).getpower());
			teambad.team.get(k).Damage(teamgood.team.get(g),teamgood.team.get(g).getpower());
			checkHealth();
			if(teamgood.team.size()<=0)
			{	System.out.println("Team Bad wins the war. The money the team has is "+b_money+".");	}
			else {	System.out.println("Team Good wins the war. The money the team has is "+g_money);	}
		}
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