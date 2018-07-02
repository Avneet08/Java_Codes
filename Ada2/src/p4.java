import java.util.*;
import java.io.*;

public class p4 {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		// Scanner sc = new Scanner(System.in);
		int n = Reader.nextInt();
		int k = Reader.nextInt();

		int sum = 0;
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Reader.nextInt();
			sum += arr[i];
		}
		Integer[] rough = new Integer[k];
		Arrays.sort(arr, Collections.reverseOrder());
		if (n == k) {
			System.out.println(sum);
		} else {
			sum = 0;
			int r = 0;
			int i = 0;
			while (i < n) {
				if (r >= k) {
					r = 0;
				}

				if (i >= k) {
					rough[r]++;
					sum += (arr[i] * rough[r]);
					r++;
				} else {

					sum += arr[i];
					rough[r] = 1;
					r++;
				}
				i++;
			}
			System.out.println(sum);
		}
	}

}

class Reader {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	/** call this method to initialize reader for InputStream */
	static void init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	/** get next word */
	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {

			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}