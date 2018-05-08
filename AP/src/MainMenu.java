import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
interface Serializable{}
class Song implements java.io.Serializable{
	 String name;
	 String Singer;
	 int duration;
	 Song(String name ,String Singer,int duration){
		 this.Singer=Singer;
		 this.name=name;
		 this.duration=duration;
	 }
	 public String getname(){
		 return this.name;
		 
	 }
	 public String getSinger(){
		 return this.Singer;
		 }
	 public int getduration(){
		 return this.duration;
		 }
	 public void getinfo(String name){
		System.out.println("Song is"+name+"Singer is"+Singer+"Duration of song is"+duration);
	 }
	
}
class Playlist implements java.io.Serializable{
	

	public ArrayList<Song> Songs=new ArrayList<Song>();
	String name;
	Playlist(String name){
		this.name=name;
		
	}
	public String getNameP(){
		return this.name;
	}
	public void add(Song a){
		Songs.add(a);
	}
	public void remove(String a) throws SongNotFoundException{
		int count=0;
		//for(Song d:Songs){
			for(int i=0;i<Songs.size();i++){
			count++;
			if(Songs.get(i).getname() != null && Songs.get(i).getname().equals(a)){
				Songs.remove(Songs.get(i));
				System.out.println(Songs.size());
				
			}
		}
		if(count==Songs.size()){
			throw new  SongNotFoundException("Song you'hv are trying to delete doesn't exist");
		}
		
	}
	public void search(String a) throws SongNotFoundException {
		int count=0;
		for(Song d : Songs){
			count++;
	        if(d.getname() != null && d.getname().equals(a)){
	           d.getinfo(a); }
	    }
		
		if(count==Songs.size()){
			throw new SongNotFoundException("Song you'hv searched doesn't exist");
		}
	}
	public int getSize(){
		if(Songs.size()==0){
			return 0;
		}else{
		return Songs.size();
	}
	}
	public void showallsongs() throws NoSongFoundException{
		if(Songs.isEmpty()){
			throw new NoSongFoundException("No songs exist in this playlist");
		}else{
		for(Song d : Songs){
	       System.out.println(d.getname()+" "+d.getSinger()+" "+d.getduration());
	    }
	}
	}
	
}
class NoSuchPlaylistException extends Exception{
	public	NoSuchPlaylistException(String	message)	{	
		super(message);	
		}
}
class SongNotFoundException extends Exception{
	public	SongNotFoundException(String	message)	{	
		super(message);	
		}
}
class NoSongFoundException extends Exception{
	public	NoSongFoundException(String	message)	{	
		super(message);	
		}
}
public class MainMenu {
	static int countplaylist=5;
	static ArrayList<Playlist> currentPlaylist=new ArrayList<Playlist>();
	static ArrayList<Playlist> playlists =new ArrayList<Playlist>();
	public static void Backtomenu(){
		for(int i=0;i<playlists.size();i++){
			System.out.println(playlists.get(i).getNameP());
		}
		
	}
	public static void addplay(Playlist p){
		countplaylist++;
		playlists.add(0,p);
	}
		//System.out.println(p.getNameP());}
	public static void search(String name) throws NoSuchPlaylistException,NoSongFoundException{
		int count=0;
		currentPlaylist.clear();
		for(int i=0;i<playlists.size();i++){
			
			if(playlists.get(i).getNameP().equals(name) && playlists.get(i).getNameP()!=null){
				currentPlaylist.add(playlists.get(i));
				
			System.out.println("Entering the playlist");
			System.out.println("List num of Songs ");
			if(playlists.get(i).getSize()==0){
				throw new NoSongFoundException("No song found in this playlist ...add some");
			}else{
				System.out.println(playlists.get(i).getSize());
			}
			
			}else{
				count++;
			}
		}
		//System.out.println(count);
		if(count==playlists.size()){
			//System.out.println(playlists.size());
			throw new NoSuchPlaylistException("oops no such playist fount ....Try Again");
		}
		
	}
	public static void serialize() throws IOException{
		ObjectOutputStream out=null;
		try{
			
			out	=	new	ObjectOutputStream	(new FileOutputStream("C:\\Users\\avnee\\Documents\\out.txt"));
			//for(Playlist p:playlists){
			//out.writeObject(p);}
		
			out.writeObject(playlists);
			}
		finally{
			playlists.clear();
			out.close();
		}
		
		
	}
	
	public static void deserialize() throws	IOException,ClassNotFoundException,EOFException{
		ObjectInputStream	in	=	null;	
		playlists.clear();
		try	{	
			in =new ObjectInputStream(new FileInputStream("C:\\Users\\avnee\\Documents\\out.txt"));	
			playlists=(ArrayList<Playlist>)in.readObject();
			
			}
		finally	{	
				in.close();	
				}	
		
		
	}
	public static void dos(String j){
		try {
			search(j);
		} catch (NoSuchPlaylistException e) {
			e.printStackTrace();
			}
		catch(NoSongFoundException e1){
			e1.printStackTrace();
			
		}
	}
	public static void main(String[] args)throws IOException, ClassNotFoundException,EOFException{
		deserialize();
		Reader.init(System.in);
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		FileReader fr = null;
		String Filename="C:\\Users\\avnee\\Documents\\1.txt";
		fr = new FileReader(Filename);
		br = new BufferedReader(fr);
		int num=3;
		
		/*for(int i=0;i<num;i++){
			String pla=br.readLine();
			//System.out.println(pla);
			Playlist p=new Playlist(pla);
			playlists.add(p);
		}*/
		
		Backtomenu();
		
		String nameplay=Reader.next();
		try {
			search(nameplay);
		} catch (NoSuchPlaylistException e) {
			e.printStackTrace();
			}
		catch(NoSongFoundException e1){
			e1.printStackTrace();
			
		}
		System.out.println("Select an option");
		System.out.println("1 add song in a playlist");
		System.out.println("2 remove song of playlist");
		System.out.println("3 search a song in playlist by name");
		System.out.println("4 show all the songs of the playlist");
		System.out.println("5 back to menu(showw all the playlist )");
		System.out.println("6 add a new  playlist");
		System.out.println("7 enter a playlisti");
		System.out.println("8 to exit the programm and save all the data");
		for(int i=0;i<100;i++){
		int yi=Reader.nextInt();
		if(yi==1){
			String s=sc.nextLine();
			String Si=sc.nextLine();
			int duration =Reader.nextInt();
			Song song=new Song(s,Si,duration);
			currentPlaylist.get(0).add(song);
			System.out.println(currentPlaylist.get(0).Songs.size());
		}
		else if(yi==2){
			String s=Reader.next();
			
			try{
				currentPlaylist.get(0).remove(s);
			}
			catch(SongNotFoundException e1){
				e1.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			}
		else if(yi==3){
			String s=Reader.next();
			try{
				currentPlaylist.get(0).search(s);
			}
			catch(SongNotFoundException e1){
				e1.getMessage();
			}
			
		}
		else if(yi==4){
			try {
				currentPlaylist.get(0).showallsongs();
			} catch (NoSongFoundException e) {
				
				e.printStackTrace();
			}
		}
		else if(yi==5){
			Backtomenu();
			String j=Reader.next();
			dos(j);
		}else if(yi==6){
			String s=sc.nextLine();
			Playlist p=new Playlist(s);
			addplay(p);
			Backtomenu();
		}else if (yi==7){
			String j=sc.nextLine();
			dos(j);
		}
		else{
			serialize();
			 System.exit(0); 
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
        while ( ! tokenizer.hasMoreElements()) {
        	
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
