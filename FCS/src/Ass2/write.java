package Ass2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class write {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " This line will be written in File";
		System.out.println("Writing to File Data.txt: " + s);
		try (FileWriter outFile = new FileWriter("hash.txt");
				BufferedWriter bWriter = new BufferedWriter(outFile)) {
			bWriter.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
