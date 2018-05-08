import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class MusicApptest2 {

	@Test
	public void test() throws SongNotFoundException, NoSongFoundException, IOException {
		/*MainMenu test=new MainMenu();
		Playlist p=new Playlist("My_PlayList_1");
		Song s1=new Song("what","Pink",647);
		Song s2=new Song("what8","Pk",678);
		Song s3=new Song("what90","Psnk",670);
		p.add(s1);p.add(s2);p.add(s3);
		String sp="what";
		p.remove(sp);
		assertEquals(2,p.getSize());*/
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		FileReader fr = null;
		String Filename="C:\\Users\\avnee\\Documents\\TestPlayList.txt";
		fr = new FileReader(Filename);
		br = new BufferedReader(fr);
		String playname=br.readLine();
		Playlist test=new Playlist(playname);
		System.out.println(playname);
		for(int i=0;i<4;i++){
			String s=br.readLine();
			String r=br.readLine();
			int dur=br.read();
			Song song=new Song(s,r,dur);
			test.add(song);
		}
		String s="vsyx";
		String r="syu sb";
		int dur=89;
		Song s1=new Song(s, r,dur);
		test.add(s1);

		test.remove(s);
		
		test.showallsongs();
		
		//p.search(sp);
		
	}

}
