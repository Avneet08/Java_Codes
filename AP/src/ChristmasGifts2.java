import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import java.util.Iterator;;

class Sort<t> implements Comparable<t> {
	private t n;

	private <T> void swap(T[] a, int i, int j) {
		if (i != j) {
			T temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

	public int compareTo(t a) {
		
		if (((Comparable) this.n).compareTo((Comparable) a) <= 0) {
			return 1;
		} else {
			return -1;
		}
	}

	public <T extends Comparable<T>> int selectionSort(T[] a) throws IOException {
		int smallest = 0;
		T rootVal = a[0];
		int rootRollno = 0;
		T prize;
		Winners win = new Winners(a.length);
		for (int i = 0; i < a.length - 1; i++) {
			smallest = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j].compareTo(a[smallest]) <= 0) {
					smallest = j;
				}
			}

			swap(a, i, smallest); // swap smallest to front
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(rootVal)) {
				rootRollno = i;
				break;
			}
		}
		int i = 0;

		rootRollno++;

		return rootRollno;
	}
}

class Test {
	int[] rollno;
	String[] Prizelist;
	int index = 0;
	int COUNT;
}

class Winners<T> implements Cloneable {
	int[] rollno;
	T[] Prizelist;
	int index = 0;
	int COUNT;
	Test c = new Test();

	public Winners(int studentno) {
		int[] Rollno = new int[studentno];
		rollno = Rollno;
		String[] prizelist = new String[studentno];
		Prizelist = (T[]) prizelist;
	}

	public Object clone() throws CloneNotSupportedException {
		Winners t = (Winners) super.clone();

		t.c = new Test();

		return t;
	}

	public Winners() {

	}

	public int getwinner() {
		
		return COUNT;
	}

}

public class ChristmasGifts2 {
	private static String FILENAME_PRE = "/Users/avnee/desktop/TEST_CASES/T5/input/";
	private static String FILENAME;
	private static int COUNT;

	public static void main(String[] args) throws CloneNotSupportedException, IOException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		PrintWriter fileout = new PrintWriter("output.txt", "UTF-8");
		final String FILENAME_WRITE = "/Users/avnee/desktop/output.txt";

		int noTree = input.nextInt();
		int noStudent = input.nextInt();
		int i;
		HashMap<Integer, String> ans = new HashMap<Integer, String>();
		int chocolates = noStudent;
		BufferedReader br = null;
		FileReader fr = null;

		BufferedWriter bw = null;
		FileWriter fw = null;

		for (i = 1; i < noTree + 1; i++) {
			String FILENAME_POST;
			FILENAME_POST = i + ".txt";
			FILENAME = FILENAME_PRE + FILENAME_POST;

			String firstLine;
			String SecondLinefloat;

			String ThirdLine;
			String SecondLine;
			String[] list = new String[noStudent];
			Float[] listfloat = new Float[noStudent];
			Integer[] listint = new Integer[noStudent];
			Winners Win = new Winners();

			try {
				fr = new FileReader(FILENAME);
				br = new BufferedReader(fr);

				firstLine = br.readLine();
				SecondLine = br.readLine();
				ThirdLine = br.readLine();

				list = ThirdLine.split(" ");
				int flag = 0;
				float outputfloat = 0;
				int outputint = 0;
				String outputstring = "";
				if (firstLine.equals("Float")) {
					for (int j = 0; j < list.length; j++) {
						listfloat[j] = Float.parseFloat(list[j]);
						outputfloat = outputfloat + listfloat[j];
						flag = 1;
					}
					// System.out.println(outputfloat);
				}
				if (firstLine.equals("Integer")) {
					for (int j = 0; j < list.length; j++) {
						listint[j] = Integer.parseInt(list[j]);
						outputint = outputint + listint[j];
						flag = 2;
					}
					// System.out.println(outputint);
				}
				if (firstLine.equals("String")) {
					for (int j = 0; j < list.length; j++) {
						outputstring = outputstring + list[j];
					}
					// System.out.println(outputstring);

				}

				Sort sort = new Sort();
				if (firstLine.equals("String")) {
					int a = sort.selectionSort(list);
					// Win = (Winners) a.clone();
					if (ans.containsKey(a)) {
						ans.put(a, ans.get(a) + " " + outputstring);
					} else {
						ans.put(a, outputstring);
						chocolates--;
					}
				}
				if (firstLine.equals("Float")) {
					int a = sort.selectionSort(listfloat);
					// Win = (Winners) a.clone();
					if (ans.containsKey(a)) {
						ans.put(a, ans.get(a) + " " + outputfloat);
						// System.out.println("apple");
					} else {
						ans.put(a, String.valueOf(outputfloat));
						chocolates--;
						// System.out.println("banana");
					}
				}
				if (firstLine.equals("Integer")) {
					int a = sort.selectionSort(listint);
					// Win = (Winners) a.clone();
					if (ans.containsKey(a)) {
						ans.put(a, ans.get(a) + " " + outputint);
					} else {
						ans.put(a, String.valueOf(outputint));
						chocolates--;
					}
				}

			} catch (IOException e) {

				e.printStackTrace();

			} finally {
				try {

					if (br != null)
						br.close();

					if (fw != null)
						fw.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}
			}
		}
		try {
			Iterator iterator = (Iterator) ans.keySet().iterator();

			// System.out.println(chocolates);
			fw = new FileWriter(FILENAME_WRITE, true);
			bw = new BufferedWriter(fw);
			while (iterator.hasNext()) {
				int key = (int) iterator.next();
				String value = ans.get(key);
				// System.out.println(value);
				// chocolates--;
				String out = key + " " + value;
				System.out.println(out);
				bw.write(key + " " + value, 0, out.length());
				bw.write("\n");
			}
			System.out.println(chocolates);
			bw.write(Integer.toString(chocolates));
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
	}
}
