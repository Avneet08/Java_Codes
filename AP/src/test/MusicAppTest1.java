package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.Test;

public class MusicAppTest1 {

	@Test
	public void test() {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		FileReader fr = null;
		String Filename="C:\\Users\\avnee\\Documents\\TestPlayList.txt";
		fr = new FileReader(Filename);
		br = new BufferedReader(fr);
		String playname=br.readLine();
		Playlist test=new Playlist(playname);
		//System.out.println(playname);
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
		test.show2();
		assertEquals( "vsyxsyu sb89",test.show2());
		//p.search(sp);
		
		
	}

}
